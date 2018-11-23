package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.RearSprocketConv;
import com.mgearapp.repository.RearSprocketConvRepository;
import com.mgearapp.service.RearSprocketConvService;
import com.mgearapp.service.dto.RearSprocketConvDTO;
import com.mgearapp.service.mapper.RearSprocketConvMapper;
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
 * Test class for the RearSprocketConvResource REST controller.
 *
 * @see RearSprocketConvResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class RearSprocketConvResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private RearSprocketConvRepository rearSprocketConvRepository;

    @Autowired
    private RearSprocketConvMapper rearSprocketConvMapper;
    
    @Autowired
    private RearSprocketConvService rearSprocketConvService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRearSprocketConvMockMvc;

    private RearSprocketConv rearSprocketConv;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RearSprocketConvResource rearSprocketConvResource = new RearSprocketConvResource(rearSprocketConvService);
        this.restRearSprocketConvMockMvc = MockMvcBuilders.standaloneSetup(rearSprocketConvResource)
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
    public static RearSprocketConv createEntity(EntityManager em) {
        RearSprocketConv rearSprocketConv = new RearSprocketConv()
            .sku(DEFAULT_SKU);
        return rearSprocketConv;
    }

    @Before
    public void initTest() {
        rearSprocketConv = createEntity(em);
    }

    @Test
    @Transactional
    public void createRearSprocketConv() throws Exception {
        int databaseSizeBeforeCreate = rearSprocketConvRepository.findAll().size();

        // Create the RearSprocketConv
        RearSprocketConvDTO rearSprocketConvDTO = rearSprocketConvMapper.toDto(rearSprocketConv);
        restRearSprocketConvMockMvc.perform(post("/api/rear-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rearSprocketConvDTO)))
            .andExpect(status().isCreated());

        // Validate the RearSprocketConv in the database
        List<RearSprocketConv> rearSprocketConvList = rearSprocketConvRepository.findAll();
        assertThat(rearSprocketConvList).hasSize(databaseSizeBeforeCreate + 1);
        RearSprocketConv testRearSprocketConv = rearSprocketConvList.get(rearSprocketConvList.size() - 1);
        assertThat(testRearSprocketConv.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createRearSprocketConvWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rearSprocketConvRepository.findAll().size();

        // Create the RearSprocketConv with an existing ID
        rearSprocketConv.setId(1L);
        RearSprocketConvDTO rearSprocketConvDTO = rearSprocketConvMapper.toDto(rearSprocketConv);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRearSprocketConvMockMvc.perform(post("/api/rear-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rearSprocketConvDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RearSprocketConv in the database
        List<RearSprocketConv> rearSprocketConvList = rearSprocketConvRepository.findAll();
        assertThat(rearSprocketConvList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRearSprocketConvs() throws Exception {
        // Initialize the database
        rearSprocketConvRepository.saveAndFlush(rearSprocketConv);

        // Get all the rearSprocketConvList
        restRearSprocketConvMockMvc.perform(get("/api/rear-sprocket-convs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rearSprocketConv.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getRearSprocketConv() throws Exception {
        // Initialize the database
        rearSprocketConvRepository.saveAndFlush(rearSprocketConv);

        // Get the rearSprocketConv
        restRearSprocketConvMockMvc.perform(get("/api/rear-sprocket-convs/{id}", rearSprocketConv.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rearSprocketConv.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRearSprocketConv() throws Exception {
        // Get the rearSprocketConv
        restRearSprocketConvMockMvc.perform(get("/api/rear-sprocket-convs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRearSprocketConv() throws Exception {
        // Initialize the database
        rearSprocketConvRepository.saveAndFlush(rearSprocketConv);

        int databaseSizeBeforeUpdate = rearSprocketConvRepository.findAll().size();

        // Update the rearSprocketConv
        RearSprocketConv updatedRearSprocketConv = rearSprocketConvRepository.findById(rearSprocketConv.getId()).get();
        // Disconnect from session so that the updates on updatedRearSprocketConv are not directly saved in db
        em.detach(updatedRearSprocketConv);
        updatedRearSprocketConv
            .sku(UPDATED_SKU);
        RearSprocketConvDTO rearSprocketConvDTO = rearSprocketConvMapper.toDto(updatedRearSprocketConv);

        restRearSprocketConvMockMvc.perform(put("/api/rear-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rearSprocketConvDTO)))
            .andExpect(status().isOk());

        // Validate the RearSprocketConv in the database
        List<RearSprocketConv> rearSprocketConvList = rearSprocketConvRepository.findAll();
        assertThat(rearSprocketConvList).hasSize(databaseSizeBeforeUpdate);
        RearSprocketConv testRearSprocketConv = rearSprocketConvList.get(rearSprocketConvList.size() - 1);
        assertThat(testRearSprocketConv.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingRearSprocketConv() throws Exception {
        int databaseSizeBeforeUpdate = rearSprocketConvRepository.findAll().size();

        // Create the RearSprocketConv
        RearSprocketConvDTO rearSprocketConvDTO = rearSprocketConvMapper.toDto(rearSprocketConv);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRearSprocketConvMockMvc.perform(put("/api/rear-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rearSprocketConvDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RearSprocketConv in the database
        List<RearSprocketConv> rearSprocketConvList = rearSprocketConvRepository.findAll();
        assertThat(rearSprocketConvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRearSprocketConv() throws Exception {
        // Initialize the database
        rearSprocketConvRepository.saveAndFlush(rearSprocketConv);

        int databaseSizeBeforeDelete = rearSprocketConvRepository.findAll().size();

        // Get the rearSprocketConv
        restRearSprocketConvMockMvc.perform(delete("/api/rear-sprocket-convs/{id}", rearSprocketConv.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RearSprocketConv> rearSprocketConvList = rearSprocketConvRepository.findAll();
        assertThat(rearSprocketConvList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RearSprocketConv.class);
        RearSprocketConv rearSprocketConv1 = new RearSprocketConv();
        rearSprocketConv1.setId(1L);
        RearSprocketConv rearSprocketConv2 = new RearSprocketConv();
        rearSprocketConv2.setId(rearSprocketConv1.getId());
        assertThat(rearSprocketConv1).isEqualTo(rearSprocketConv2);
        rearSprocketConv2.setId(2L);
        assertThat(rearSprocketConv1).isNotEqualTo(rearSprocketConv2);
        rearSprocketConv1.setId(null);
        assertThat(rearSprocketConv1).isNotEqualTo(rearSprocketConv2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RearSprocketConvDTO.class);
        RearSprocketConvDTO rearSprocketConvDTO1 = new RearSprocketConvDTO();
        rearSprocketConvDTO1.setId(1L);
        RearSprocketConvDTO rearSprocketConvDTO2 = new RearSprocketConvDTO();
        assertThat(rearSprocketConvDTO1).isNotEqualTo(rearSprocketConvDTO2);
        rearSprocketConvDTO2.setId(rearSprocketConvDTO1.getId());
        assertThat(rearSprocketConvDTO1).isEqualTo(rearSprocketConvDTO2);
        rearSprocketConvDTO2.setId(2L);
        assertThat(rearSprocketConvDTO1).isNotEqualTo(rearSprocketConvDTO2);
        rearSprocketConvDTO1.setId(null);
        assertThat(rearSprocketConvDTO1).isNotEqualTo(rearSprocketConvDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(rearSprocketConvMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(rearSprocketConvMapper.fromId(null)).isNull();
    }
}
