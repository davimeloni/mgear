package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BikeRearSprocket;
import com.mgearapp.repository.BikeRearSprocketRepository;
import com.mgearapp.service.BikeRearSprocketService;
import com.mgearapp.service.dto.BikeRearSprocketDTO;
import com.mgearapp.service.mapper.BikeRearSprocketMapper;
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
 * Test class for the BikeRearSprocketResource REST controller.
 *
 * @see BikeRearSprocketResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BikeRearSprocketResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private BikeRearSprocketRepository bikeRearSprocketRepository;

    @Autowired
    private BikeRearSprocketMapper bikeRearSprocketMapper;
    
    @Autowired
    private BikeRearSprocketService bikeRearSprocketService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBikeRearSprocketMockMvc;

    private BikeRearSprocket bikeRearSprocket;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BikeRearSprocketResource bikeRearSprocketResource = new BikeRearSprocketResource(bikeRearSprocketService);
        this.restBikeRearSprocketMockMvc = MockMvcBuilders.standaloneSetup(bikeRearSprocketResource)
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
    public static BikeRearSprocket createEntity(EntityManager em) {
        BikeRearSprocket bikeRearSprocket = new BikeRearSprocket()
            .sku(DEFAULT_SKU);
        return bikeRearSprocket;
    }

    @Before
    public void initTest() {
        bikeRearSprocket = createEntity(em);
    }

    @Test
    @Transactional
    public void createBikeRearSprocket() throws Exception {
        int databaseSizeBeforeCreate = bikeRearSprocketRepository.findAll().size();

        // Create the BikeRearSprocket
        BikeRearSprocketDTO bikeRearSprocketDTO = bikeRearSprocketMapper.toDto(bikeRearSprocket);
        restBikeRearSprocketMockMvc.perform(post("/api/bike-rear-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeRearSprocketDTO)))
            .andExpect(status().isCreated());

        // Validate the BikeRearSprocket in the database
        List<BikeRearSprocket> bikeRearSprocketList = bikeRearSprocketRepository.findAll();
        assertThat(bikeRearSprocketList).hasSize(databaseSizeBeforeCreate + 1);
        BikeRearSprocket testBikeRearSprocket = bikeRearSprocketList.get(bikeRearSprocketList.size() - 1);
        assertThat(testBikeRearSprocket.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createBikeRearSprocketWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bikeRearSprocketRepository.findAll().size();

        // Create the BikeRearSprocket with an existing ID
        bikeRearSprocket.setId(1L);
        BikeRearSprocketDTO bikeRearSprocketDTO = bikeRearSprocketMapper.toDto(bikeRearSprocket);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBikeRearSprocketMockMvc.perform(post("/api/bike-rear-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeRearSprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeRearSprocket in the database
        List<BikeRearSprocket> bikeRearSprocketList = bikeRearSprocketRepository.findAll();
        assertThat(bikeRearSprocketList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBikeRearSprockets() throws Exception {
        // Initialize the database
        bikeRearSprocketRepository.saveAndFlush(bikeRearSprocket);

        // Get all the bikeRearSprocketList
        restBikeRearSprocketMockMvc.perform(get("/api/bike-rear-sprockets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bikeRearSprocket.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getBikeRearSprocket() throws Exception {
        // Initialize the database
        bikeRearSprocketRepository.saveAndFlush(bikeRearSprocket);

        // Get the bikeRearSprocket
        restBikeRearSprocketMockMvc.perform(get("/api/bike-rear-sprockets/{id}", bikeRearSprocket.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bikeRearSprocket.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBikeRearSprocket() throws Exception {
        // Get the bikeRearSprocket
        restBikeRearSprocketMockMvc.perform(get("/api/bike-rear-sprockets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBikeRearSprocket() throws Exception {
        // Initialize the database
        bikeRearSprocketRepository.saveAndFlush(bikeRearSprocket);

        int databaseSizeBeforeUpdate = bikeRearSprocketRepository.findAll().size();

        // Update the bikeRearSprocket
        BikeRearSprocket updatedBikeRearSprocket = bikeRearSprocketRepository.findById(bikeRearSprocket.getId()).get();
        // Disconnect from session so that the updates on updatedBikeRearSprocket are not directly saved in db
        em.detach(updatedBikeRearSprocket);
        updatedBikeRearSprocket
            .sku(UPDATED_SKU);
        BikeRearSprocketDTO bikeRearSprocketDTO = bikeRearSprocketMapper.toDto(updatedBikeRearSprocket);

        restBikeRearSprocketMockMvc.perform(put("/api/bike-rear-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeRearSprocketDTO)))
            .andExpect(status().isOk());

        // Validate the BikeRearSprocket in the database
        List<BikeRearSprocket> bikeRearSprocketList = bikeRearSprocketRepository.findAll();
        assertThat(bikeRearSprocketList).hasSize(databaseSizeBeforeUpdate);
        BikeRearSprocket testBikeRearSprocket = bikeRearSprocketList.get(bikeRearSprocketList.size() - 1);
        assertThat(testBikeRearSprocket.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingBikeRearSprocket() throws Exception {
        int databaseSizeBeforeUpdate = bikeRearSprocketRepository.findAll().size();

        // Create the BikeRearSprocket
        BikeRearSprocketDTO bikeRearSprocketDTO = bikeRearSprocketMapper.toDto(bikeRearSprocket);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBikeRearSprocketMockMvc.perform(put("/api/bike-rear-sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeRearSprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BikeRearSprocket in the database
        List<BikeRearSprocket> bikeRearSprocketList = bikeRearSprocketRepository.findAll();
        assertThat(bikeRearSprocketList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBikeRearSprocket() throws Exception {
        // Initialize the database
        bikeRearSprocketRepository.saveAndFlush(bikeRearSprocket);

        int databaseSizeBeforeDelete = bikeRearSprocketRepository.findAll().size();

        // Get the bikeRearSprocket
        restBikeRearSprocketMockMvc.perform(delete("/api/bike-rear-sprockets/{id}", bikeRearSprocket.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BikeRearSprocket> bikeRearSprocketList = bikeRearSprocketRepository.findAll();
        assertThat(bikeRearSprocketList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeRearSprocket.class);
        BikeRearSprocket bikeRearSprocket1 = new BikeRearSprocket();
        bikeRearSprocket1.setId(1L);
        BikeRearSprocket bikeRearSprocket2 = new BikeRearSprocket();
        bikeRearSprocket2.setId(bikeRearSprocket1.getId());
        assertThat(bikeRearSprocket1).isEqualTo(bikeRearSprocket2);
        bikeRearSprocket2.setId(2L);
        assertThat(bikeRearSprocket1).isNotEqualTo(bikeRearSprocket2);
        bikeRearSprocket1.setId(null);
        assertThat(bikeRearSprocket1).isNotEqualTo(bikeRearSprocket2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeRearSprocketDTO.class);
        BikeRearSprocketDTO bikeRearSprocketDTO1 = new BikeRearSprocketDTO();
        bikeRearSprocketDTO1.setId(1L);
        BikeRearSprocketDTO bikeRearSprocketDTO2 = new BikeRearSprocketDTO();
        assertThat(bikeRearSprocketDTO1).isNotEqualTo(bikeRearSprocketDTO2);
        bikeRearSprocketDTO2.setId(bikeRearSprocketDTO1.getId());
        assertThat(bikeRearSprocketDTO1).isEqualTo(bikeRearSprocketDTO2);
        bikeRearSprocketDTO2.setId(2L);
        assertThat(bikeRearSprocketDTO1).isNotEqualTo(bikeRearSprocketDTO2);
        bikeRearSprocketDTO1.setId(null);
        assertThat(bikeRearSprocketDTO1).isNotEqualTo(bikeRearSprocketDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bikeRearSprocketMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bikeRearSprocketMapper.fromId(null)).isNull();
    }
}
