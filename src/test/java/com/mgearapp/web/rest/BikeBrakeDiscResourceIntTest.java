package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BikeBrakeDisc;
import com.mgearapp.repository.BikeBrakeDiscRepository;
import com.mgearapp.service.BikeBrakeDiscService;
import com.mgearapp.service.dto.BikeBrakeDiscDTO;
import com.mgearapp.service.mapper.BikeBrakeDiscMapper;
import com.mgearapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.mgearapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BikeBrakeDiscResource REST controller.
 *
 * @see BikeBrakeDiscResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BikeBrakeDiscResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private BikeBrakeDiscRepository bikeBrakeDiscRepository;

    @Autowired
    private BikeBrakeDiscMapper bikeBrakeDiscMapper;
    
    @Autowired
    private BikeBrakeDiscService bikeBrakeDiscService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBikeBrakeDiscMockMvc;

    private BikeBrakeDisc bikeBrakeDisc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BikeBrakeDiscResource bikeBrakeDiscResource = new BikeBrakeDiscResource(bikeBrakeDiscService);
        this.restBikeBrakeDiscMockMvc = MockMvcBuilders.standaloneSetup(bikeBrakeDiscResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BikeBrakeDisc createEntity(EntityManager em) {
        BikeBrakeDisc bikeBrakeDisc = new BikeBrakeDisc()
            .sku(DEFAULT_SKU);
        return bikeBrakeDisc;
    }

    @Before
    public void initTest() {
        bikeBrakeDisc = createEntity(em);
    }

    @Test
    @Transactional
    public void createBikeBrakeDisc() throws Exception {
        int databaseSizeBeforeCreate = bikeBrakeDiscRepository.findAll().size();

        // Create the BikeBrakeDisc
        BikeBrakeDiscDTO bikeBrakeDiscDTO = bikeBrakeDiscMapper.toDto(bikeBrakeDisc);
        restBikeBrakeDiscMockMvc.perform(post("/api/bike-brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakeDiscDTO)))
            .andExpect(status().isCreated());

        // Validate the BikeBrakeDisc in the database
        List<BikeBrakeDisc> bikeBrakeDiscList = bikeBrakeDiscRepository.findAll();
        assertThat(bikeBrakeDiscList).hasSize(databaseSizeBeforeCreate + 1);
        BikeBrakeDisc testBikeBrakeDisc = bikeBrakeDiscList.get(bikeBrakeDiscList.size() - 1);
        assertThat(testBikeBrakeDisc.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createBikeBrakeDiscWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bikeBrakeDiscRepository.findAll().size();

        // Create the BikeBrakeDisc with an existing ID
        bikeBrakeDisc.setId(1L);
        BikeBrakeDiscDTO bikeBrakeDiscDTO = bikeBrakeDiscMapper.toDto(bikeBrakeDisc);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBikeBrakeDiscMockMvc.perform(post("/api/bike-brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakeDiscDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeBrakeDisc in the database
        List<BikeBrakeDisc> bikeBrakeDiscList = bikeBrakeDiscRepository.findAll();
        assertThat(bikeBrakeDiscList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBikeBrakeDiscs() throws Exception {
        // Initialize the database
        bikeBrakeDiscRepository.saveAndFlush(bikeBrakeDisc);

        // Get all the bikeBrakeDiscList
        restBikeBrakeDiscMockMvc.perform(get("/api/bike-brake-discs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bikeBrakeDisc.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getBikeBrakeDisc() throws Exception {
        // Initialize the database
        bikeBrakeDiscRepository.saveAndFlush(bikeBrakeDisc);

        // Get the bikeBrakeDisc
        restBikeBrakeDiscMockMvc.perform(get("/api/bike-brake-discs/{id}", bikeBrakeDisc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bikeBrakeDisc.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBikeBrakeDisc() throws Exception {
        // Get the bikeBrakeDisc
        restBikeBrakeDiscMockMvc.perform(get("/api/bike-brake-discs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBikeBrakeDisc() throws Exception {
        // Initialize the database
        bikeBrakeDiscRepository.saveAndFlush(bikeBrakeDisc);

        int databaseSizeBeforeUpdate = bikeBrakeDiscRepository.findAll().size();

        // Update the bikeBrakeDisc
        BikeBrakeDisc updatedBikeBrakeDisc = bikeBrakeDiscRepository.findById(bikeBrakeDisc.getId()).get();
        // Disconnect from session so that the updates on updatedBikeBrakeDisc are not directly saved in db
        em.detach(updatedBikeBrakeDisc);
        updatedBikeBrakeDisc
            .sku(UPDATED_SKU);
        BikeBrakeDiscDTO bikeBrakeDiscDTO = bikeBrakeDiscMapper.toDto(updatedBikeBrakeDisc);

        restBikeBrakeDiscMockMvc.perform(put("/api/bike-brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakeDiscDTO)))
            .andExpect(status().isOk());

        // Validate the BikeBrakeDisc in the database
        List<BikeBrakeDisc> bikeBrakeDiscList = bikeBrakeDiscRepository.findAll();
        assertThat(bikeBrakeDiscList).hasSize(databaseSizeBeforeUpdate);
        BikeBrakeDisc testBikeBrakeDisc = bikeBrakeDiscList.get(bikeBrakeDiscList.size() - 1);
        assertThat(testBikeBrakeDisc.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingBikeBrakeDisc() throws Exception {
        int databaseSizeBeforeUpdate = bikeBrakeDiscRepository.findAll().size();

        // Create the BikeBrakeDisc
        BikeBrakeDiscDTO bikeBrakeDiscDTO = bikeBrakeDiscMapper.toDto(bikeBrakeDisc);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBikeBrakeDiscMockMvc.perform(put("/api/bike-brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakeDiscDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeBrakeDisc in the database
        List<BikeBrakeDisc> bikeBrakeDiscList = bikeBrakeDiscRepository.findAll();
        assertThat(bikeBrakeDiscList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBikeBrakeDisc() throws Exception {
        // Initialize the database
        bikeBrakeDiscRepository.saveAndFlush(bikeBrakeDisc);

        int databaseSizeBeforeDelete = bikeBrakeDiscRepository.findAll().size();

        // Get the bikeBrakeDisc
        restBikeBrakeDiscMockMvc.perform(delete("/api/bike-brake-discs/{id}", bikeBrakeDisc.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BikeBrakeDisc> bikeBrakeDiscList = bikeBrakeDiscRepository.findAll();
        assertThat(bikeBrakeDiscList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeBrakeDisc.class);
        BikeBrakeDisc bikeBrakeDisc1 = new BikeBrakeDisc();
        bikeBrakeDisc1.setId(1L);
        BikeBrakeDisc bikeBrakeDisc2 = new BikeBrakeDisc();
        bikeBrakeDisc2.setId(bikeBrakeDisc1.getId());
        assertThat(bikeBrakeDisc1).isEqualTo(bikeBrakeDisc2);
        bikeBrakeDisc2.setId(2L);
        assertThat(bikeBrakeDisc1).isNotEqualTo(bikeBrakeDisc2);
        bikeBrakeDisc1.setId(null);
        assertThat(bikeBrakeDisc1).isNotEqualTo(bikeBrakeDisc2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeBrakeDiscDTO.class);
        BikeBrakeDiscDTO bikeBrakeDiscDTO1 = new BikeBrakeDiscDTO();
        bikeBrakeDiscDTO1.setId(1L);
        BikeBrakeDiscDTO bikeBrakeDiscDTO2 = new BikeBrakeDiscDTO();
        assertThat(bikeBrakeDiscDTO1).isNotEqualTo(bikeBrakeDiscDTO2);
        bikeBrakeDiscDTO2.setId(bikeBrakeDiscDTO1.getId());
        assertThat(bikeBrakeDiscDTO1).isEqualTo(bikeBrakeDiscDTO2);
        bikeBrakeDiscDTO2.setId(2L);
        assertThat(bikeBrakeDiscDTO1).isNotEqualTo(bikeBrakeDiscDTO2);
        bikeBrakeDiscDTO1.setId(null);
        assertThat(bikeBrakeDiscDTO1).isNotEqualTo(bikeBrakeDiscDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bikeBrakeDiscMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bikeBrakeDiscMapper.fromId(null)).isNull();
    }
}
