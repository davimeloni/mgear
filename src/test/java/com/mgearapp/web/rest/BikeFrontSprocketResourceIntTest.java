package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BikeFrontSprocket;
import com.mgearapp.repository.BikeFrontSprocketRepository;
import com.mgearapp.service.BikeFrontSprocketService;
import com.mgearapp.service.dto.BikeFrontSprocketDTO;
import com.mgearapp.service.mapper.BikeFrontSprocketMapper;
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
 * Test class for the BikeFrontSprocketResource REST controller.
 *
 * @see BikeFrontSprocketResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BikeFrontSprocketResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private BikeFrontSprocketRepository bikeFrontSprocketRepository;

    @Autowired
    private BikeFrontSprocketMapper bikeFrontSprocketMapper;
    
    @Autowired
    private BikeFrontSprocketService bikeFrontSprocketService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBikeFrontSprocketMockMvc;

    private BikeFrontSprocket bikeFrontSprocket;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BikeFrontSprocketResource bikeFrontSprocketResource = new BikeFrontSprocketResource(bikeFrontSprocketService);
        this.restBikeFrontSprocketMockMvc = MockMvcBuilders.standaloneSetup(bikeFrontSprocketResource)
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
    public static BikeFrontSprocket createEntity(EntityManager em) {
        BikeFrontSprocket bikeFrontSprocket = new BikeFrontSprocket()
            .sku(DEFAULT_SKU);
        return bikeFrontSprocket;
    }

    @Before
    public void initTest() {
        bikeFrontSprocket = createEntity(em);
    }

    @Test
    @Transactional
    public void createBikeFrontSprocket() throws Exception {
        int databaseSizeBeforeCreate = bikeFrontSprocketRepository.findAll().size();

        // Create the BikeFrontSprocket
        BikeFrontSprocketDTO bikeFrontSprocketDTO = bikeFrontSprocketMapper.toDto(bikeFrontSprocket);
        restBikeFrontSprocketMockMvc.perform(post("/api/bike-front-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeFrontSprocketDTO)))
            .andExpect(status().isCreated());

        // Validate the BikeFrontSprocket in the database
        List<BikeFrontSprocket> bikeFrontSprocketList = bikeFrontSprocketRepository.findAll();
        assertThat(bikeFrontSprocketList).hasSize(databaseSizeBeforeCreate + 1);
        BikeFrontSprocket testBikeFrontSprocket = bikeFrontSprocketList.get(bikeFrontSprocketList.size() - 1);
        assertThat(testBikeFrontSprocket.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createBikeFrontSprocketWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bikeFrontSprocketRepository.findAll().size();

        // Create the BikeFrontSprocket with an existing ID
        bikeFrontSprocket.setId(1L);
        BikeFrontSprocketDTO bikeFrontSprocketDTO = bikeFrontSprocketMapper.toDto(bikeFrontSprocket);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBikeFrontSprocketMockMvc.perform(post("/api/bike-front-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeFrontSprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeFrontSprocket in the database
        List<BikeFrontSprocket> bikeFrontSprocketList = bikeFrontSprocketRepository.findAll();
        assertThat(bikeFrontSprocketList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBikeFrontSprockets() throws Exception {
        // Initialize the database
        bikeFrontSprocketRepository.saveAndFlush(bikeFrontSprocket);

        // Get all the bikeFrontSprocketList
        restBikeFrontSprocketMockMvc.perform(get("/api/bike-front-sprockets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bikeFrontSprocket.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getBikeFrontSprocket() throws Exception {
        // Initialize the database
        bikeFrontSprocketRepository.saveAndFlush(bikeFrontSprocket);

        // Get the bikeFrontSprocket
        restBikeFrontSprocketMockMvc.perform(get("/api/bike-front-sprockets/{id}", bikeFrontSprocket.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bikeFrontSprocket.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBikeFrontSprocket() throws Exception {
        // Get the bikeFrontSprocket
        restBikeFrontSprocketMockMvc.perform(get("/api/bike-front-sprockets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBikeFrontSprocket() throws Exception {
        // Initialize the database
        bikeFrontSprocketRepository.saveAndFlush(bikeFrontSprocket);

        int databaseSizeBeforeUpdate = bikeFrontSprocketRepository.findAll().size();

        // Update the bikeFrontSprocket
        BikeFrontSprocket updatedBikeFrontSprocket = bikeFrontSprocketRepository.findById(bikeFrontSprocket.getId()).get();
        // Disconnect from session so that the updates on updatedBikeFrontSprocket are not directly saved in db
        em.detach(updatedBikeFrontSprocket);
        updatedBikeFrontSprocket
            .sku(UPDATED_SKU);
        BikeFrontSprocketDTO bikeFrontSprocketDTO = bikeFrontSprocketMapper.toDto(updatedBikeFrontSprocket);

        restBikeFrontSprocketMockMvc.perform(put("/api/bike-front-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeFrontSprocketDTO)))
            .andExpect(status().isOk());

        // Validate the BikeFrontSprocket in the database
        List<BikeFrontSprocket> bikeFrontSprocketList = bikeFrontSprocketRepository.findAll();
        assertThat(bikeFrontSprocketList).hasSize(databaseSizeBeforeUpdate);
        BikeFrontSprocket testBikeFrontSprocket = bikeFrontSprocketList.get(bikeFrontSprocketList.size() - 1);
        assertThat(testBikeFrontSprocket.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingBikeFrontSprocket() throws Exception {
        int databaseSizeBeforeUpdate = bikeFrontSprocketRepository.findAll().size();

        // Create the BikeFrontSprocket
        BikeFrontSprocketDTO bikeFrontSprocketDTO = bikeFrontSprocketMapper.toDto(bikeFrontSprocket);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBikeFrontSprocketMockMvc.perform(put("/api/bike-front-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeFrontSprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeFrontSprocket in the database
        List<BikeFrontSprocket> bikeFrontSprocketList = bikeFrontSprocketRepository.findAll();
        assertThat(bikeFrontSprocketList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBikeFrontSprocket() throws Exception {
        // Initialize the database
        bikeFrontSprocketRepository.saveAndFlush(bikeFrontSprocket);

        int databaseSizeBeforeDelete = bikeFrontSprocketRepository.findAll().size();

        // Get the bikeFrontSprocket
        restBikeFrontSprocketMockMvc.perform(delete("/api/bike-front-sprockets/{id}", bikeFrontSprocket.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BikeFrontSprocket> bikeFrontSprocketList = bikeFrontSprocketRepository.findAll();
        assertThat(bikeFrontSprocketList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeFrontSprocket.class);
        BikeFrontSprocket bikeFrontSprocket1 = new BikeFrontSprocket();
        bikeFrontSprocket1.setId(1L);
        BikeFrontSprocket bikeFrontSprocket2 = new BikeFrontSprocket();
        bikeFrontSprocket2.setId(bikeFrontSprocket1.getId());
        assertThat(bikeFrontSprocket1).isEqualTo(bikeFrontSprocket2);
        bikeFrontSprocket2.setId(2L);
        assertThat(bikeFrontSprocket1).isNotEqualTo(bikeFrontSprocket2);
        bikeFrontSprocket1.setId(null);
        assertThat(bikeFrontSprocket1).isNotEqualTo(bikeFrontSprocket2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeFrontSprocketDTO.class);
        BikeFrontSprocketDTO bikeFrontSprocketDTO1 = new BikeFrontSprocketDTO();
        bikeFrontSprocketDTO1.setId(1L);
        BikeFrontSprocketDTO bikeFrontSprocketDTO2 = new BikeFrontSprocketDTO();
        assertThat(bikeFrontSprocketDTO1).isNotEqualTo(bikeFrontSprocketDTO2);
        bikeFrontSprocketDTO2.setId(bikeFrontSprocketDTO1.getId());
        assertThat(bikeFrontSprocketDTO1).isEqualTo(bikeFrontSprocketDTO2);
        bikeFrontSprocketDTO2.setId(2L);
        assertThat(bikeFrontSprocketDTO1).isNotEqualTo(bikeFrontSprocketDTO2);
        bikeFrontSprocketDTO1.setId(null);
        assertThat(bikeFrontSprocketDTO1).isNotEqualTo(bikeFrontSprocketDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bikeFrontSprocketMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bikeFrontSprocketMapper.fromId(null)).isNull();
    }
}
