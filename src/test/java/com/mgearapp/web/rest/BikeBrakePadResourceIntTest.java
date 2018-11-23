package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BikeBrakePad;
import com.mgearapp.repository.BikeBrakePadRepository;
import com.mgearapp.service.BikeBrakePadService;
import com.mgearapp.service.dto.BikeBrakePadDTO;
import com.mgearapp.service.mapper.BikeBrakePadMapper;
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
 * Test class for the BikeBrakePadResource REST controller.
 *
 * @see BikeBrakePadResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BikeBrakePadResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private BikeBrakePadRepository bikeBrakePadRepository;

    @Autowired
    private BikeBrakePadMapper bikeBrakePadMapper;
    
    @Autowired
    private BikeBrakePadService bikeBrakePadService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBikeBrakePadMockMvc;

    private BikeBrakePad bikeBrakePad;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BikeBrakePadResource bikeBrakePadResource = new BikeBrakePadResource(bikeBrakePadService);
        this.restBikeBrakePadMockMvc = MockMvcBuilders.standaloneSetup(bikeBrakePadResource)
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
    public static BikeBrakePad createEntity(EntityManager em) {
        BikeBrakePad bikeBrakePad = new BikeBrakePad()
            .sku(DEFAULT_SKU);
        return bikeBrakePad;
    }

    @Before
    public void initTest() {
        bikeBrakePad = createEntity(em);
    }

    @Test
    @Transactional
    public void createBikeBrakePad() throws Exception {
        int databaseSizeBeforeCreate = bikeBrakePadRepository.findAll().size();

        // Create the BikeBrakePad
        BikeBrakePadDTO bikeBrakePadDTO = bikeBrakePadMapper.toDto(bikeBrakePad);
        restBikeBrakePadMockMvc.perform(post("/api/bike-brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakePadDTO)))
            .andExpect(status().isCreated());

        // Validate the BikeBrakePad in the database
        List<BikeBrakePad> bikeBrakePadList = bikeBrakePadRepository.findAll();
        assertThat(bikeBrakePadList).hasSize(databaseSizeBeforeCreate + 1);
        BikeBrakePad testBikeBrakePad = bikeBrakePadList.get(bikeBrakePadList.size() - 1);
        assertThat(testBikeBrakePad.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createBikeBrakePadWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bikeBrakePadRepository.findAll().size();

        // Create the BikeBrakePad with an existing ID
        bikeBrakePad.setId(1L);
        BikeBrakePadDTO bikeBrakePadDTO = bikeBrakePadMapper.toDto(bikeBrakePad);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBikeBrakePadMockMvc.perform(post("/api/bike-brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakePadDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeBrakePad in the database
        List<BikeBrakePad> bikeBrakePadList = bikeBrakePadRepository.findAll();
        assertThat(bikeBrakePadList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBikeBrakePads() throws Exception {
        // Initialize the database
        bikeBrakePadRepository.saveAndFlush(bikeBrakePad);

        // Get all the bikeBrakePadList
        restBikeBrakePadMockMvc.perform(get("/api/bike-brake-pads?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bikeBrakePad.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getBikeBrakePad() throws Exception {
        // Initialize the database
        bikeBrakePadRepository.saveAndFlush(bikeBrakePad);

        // Get the bikeBrakePad
        restBikeBrakePadMockMvc.perform(get("/api/bike-brake-pads/{id}", bikeBrakePad.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bikeBrakePad.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBikeBrakePad() throws Exception {
        // Get the bikeBrakePad
        restBikeBrakePadMockMvc.perform(get("/api/bike-brake-pads/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBikeBrakePad() throws Exception {
        // Initialize the database
        bikeBrakePadRepository.saveAndFlush(bikeBrakePad);

        int databaseSizeBeforeUpdate = bikeBrakePadRepository.findAll().size();

        // Update the bikeBrakePad
        BikeBrakePad updatedBikeBrakePad = bikeBrakePadRepository.findById(bikeBrakePad.getId()).get();
        // Disconnect from session so that the updates on updatedBikeBrakePad are not directly saved in db
        em.detach(updatedBikeBrakePad);
        updatedBikeBrakePad
            .sku(UPDATED_SKU);
        BikeBrakePadDTO bikeBrakePadDTO = bikeBrakePadMapper.toDto(updatedBikeBrakePad);

        restBikeBrakePadMockMvc.perform(put("/api/bike-brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakePadDTO)))
            .andExpect(status().isOk());

        // Validate the BikeBrakePad in the database
        List<BikeBrakePad> bikeBrakePadList = bikeBrakePadRepository.findAll();
        assertThat(bikeBrakePadList).hasSize(databaseSizeBeforeUpdate);
        BikeBrakePad testBikeBrakePad = bikeBrakePadList.get(bikeBrakePadList.size() - 1);
        assertThat(testBikeBrakePad.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingBikeBrakePad() throws Exception {
        int databaseSizeBeforeUpdate = bikeBrakePadRepository.findAll().size();

        // Create the BikeBrakePad
        BikeBrakePadDTO bikeBrakePadDTO = bikeBrakePadMapper.toDto(bikeBrakePad);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBikeBrakePadMockMvc.perform(put("/api/bike-brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeBrakePadDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeBrakePad in the database
        List<BikeBrakePad> bikeBrakePadList = bikeBrakePadRepository.findAll();
        assertThat(bikeBrakePadList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBikeBrakePad() throws Exception {
        // Initialize the database
        bikeBrakePadRepository.saveAndFlush(bikeBrakePad);

        int databaseSizeBeforeDelete = bikeBrakePadRepository.findAll().size();

        // Get the bikeBrakePad
        restBikeBrakePadMockMvc.perform(delete("/api/bike-brake-pads/{id}", bikeBrakePad.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BikeBrakePad> bikeBrakePadList = bikeBrakePadRepository.findAll();
        assertThat(bikeBrakePadList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeBrakePad.class);
        BikeBrakePad bikeBrakePad1 = new BikeBrakePad();
        bikeBrakePad1.setId(1L);
        BikeBrakePad bikeBrakePad2 = new BikeBrakePad();
        bikeBrakePad2.setId(bikeBrakePad1.getId());
        assertThat(bikeBrakePad1).isEqualTo(bikeBrakePad2);
        bikeBrakePad2.setId(2L);
        assertThat(bikeBrakePad1).isNotEqualTo(bikeBrakePad2);
        bikeBrakePad1.setId(null);
        assertThat(bikeBrakePad1).isNotEqualTo(bikeBrakePad2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeBrakePadDTO.class);
        BikeBrakePadDTO bikeBrakePadDTO1 = new BikeBrakePadDTO();
        bikeBrakePadDTO1.setId(1L);
        BikeBrakePadDTO bikeBrakePadDTO2 = new BikeBrakePadDTO();
        assertThat(bikeBrakePadDTO1).isNotEqualTo(bikeBrakePadDTO2);
        bikeBrakePadDTO2.setId(bikeBrakePadDTO1.getId());
        assertThat(bikeBrakePadDTO1).isEqualTo(bikeBrakePadDTO2);
        bikeBrakePadDTO2.setId(2L);
        assertThat(bikeBrakePadDTO1).isNotEqualTo(bikeBrakePadDTO2);
        bikeBrakePadDTO1.setId(null);
        assertThat(bikeBrakePadDTO1).isNotEqualTo(bikeBrakePadDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bikeBrakePadMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bikeBrakePadMapper.fromId(null)).isNull();
    }
}
