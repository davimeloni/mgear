package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.FrontSprocketConv;
import com.mgearapp.repository.FrontSprocketConvRepository;
import com.mgearapp.service.FrontSprocketConvService;
import com.mgearapp.service.dto.FrontSprocketConvDTO;
import com.mgearapp.service.mapper.FrontSprocketConvMapper;
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
 * Test class for the FrontSprocketConvResource REST controller.
 *
 * @see FrontSprocketConvResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class FrontSprocketConvResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    @Autowired
    private FrontSprocketConvRepository frontSprocketConvRepository;

    @Autowired
    private FrontSprocketConvMapper frontSprocketConvMapper;
    
    @Autowired
    private FrontSprocketConvService frontSprocketConvService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFrontSprocketConvMockMvc;

    private FrontSprocketConv frontSprocketConv;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FrontSprocketConvResource frontSprocketConvResource = new FrontSprocketConvResource(frontSprocketConvService);
        this.restFrontSprocketConvMockMvc = MockMvcBuilders.standaloneSetup(frontSprocketConvResource)
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
    public static FrontSprocketConv createEntity(EntityManager em) {
        FrontSprocketConv frontSprocketConv = new FrontSprocketConv()
            .sku(DEFAULT_SKU);
        return frontSprocketConv;
    }

    @Before
    public void initTest() {
        frontSprocketConv = createEntity(em);
    }

    @Test
    @Transactional
    public void createFrontSprocketConv() throws Exception {
        int databaseSizeBeforeCreate = frontSprocketConvRepository.findAll().size();

        // Create the FrontSprocketConv
        FrontSprocketConvDTO frontSprocketConvDTO = frontSprocketConvMapper.toDto(frontSprocketConv);
        restFrontSprocketConvMockMvc.perform(post("/api/front-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(frontSprocketConvDTO)))
            .andExpect(status().isCreated());

        // Validate the FrontSprocketConv in the database
        List<FrontSprocketConv> frontSprocketConvList = frontSprocketConvRepository.findAll();
        assertThat(frontSprocketConvList).hasSize(databaseSizeBeforeCreate + 1);
        FrontSprocketConv testFrontSprocketConv = frontSprocketConvList.get(frontSprocketConvList.size() - 1);
        assertThat(testFrontSprocketConv.getSku()).isEqualTo(DEFAULT_SKU);
    }

    @Test
    @Transactional
    public void createFrontSprocketConvWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = frontSprocketConvRepository.findAll().size();

        // Create the FrontSprocketConv with an existing ID
        frontSprocketConv.setId(1L);
        FrontSprocketConvDTO frontSprocketConvDTO = frontSprocketConvMapper.toDto(frontSprocketConv);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFrontSprocketConvMockMvc.perform(post("/api/front-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(frontSprocketConvDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FrontSprocketConv in the database
        List<FrontSprocketConv> frontSprocketConvList = frontSprocketConvRepository.findAll();
        assertThat(frontSprocketConvList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllFrontSprocketConvs() throws Exception {
        // Initialize the database
        frontSprocketConvRepository.saveAndFlush(frontSprocketConv);

        // Get all the frontSprocketConvList
        restFrontSprocketConvMockMvc.perform(get("/api/front-sprocket-convs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(frontSprocketConv.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())));
    }
    
    @Test
    @Transactional
    public void getFrontSprocketConv() throws Exception {
        // Initialize the database
        frontSprocketConvRepository.saveAndFlush(frontSprocketConv);

        // Get the frontSprocketConv
        restFrontSprocketConvMockMvc.perform(get("/api/front-sprocket-convs/{id}", frontSprocketConv.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(frontSprocketConv.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFrontSprocketConv() throws Exception {
        // Get the frontSprocketConv
        restFrontSprocketConvMockMvc.perform(get("/api/front-sprocket-convs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFrontSprocketConv() throws Exception {
        // Initialize the database
        frontSprocketConvRepository.saveAndFlush(frontSprocketConv);

        int databaseSizeBeforeUpdate = frontSprocketConvRepository.findAll().size();

        // Update the frontSprocketConv
        FrontSprocketConv updatedFrontSprocketConv = frontSprocketConvRepository.findById(frontSprocketConv.getId()).get();
        // Disconnect from session so that the updates on updatedFrontSprocketConv are not directly saved in db
        em.detach(updatedFrontSprocketConv);
        updatedFrontSprocketConv
            .sku(UPDATED_SKU);
        FrontSprocketConvDTO frontSprocketConvDTO = frontSprocketConvMapper.toDto(updatedFrontSprocketConv);

        restFrontSprocketConvMockMvc.perform(put("/api/front-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(frontSprocketConvDTO)))
            .andExpect(status().isOk());

        // Validate the FrontSprocketConv in the database
        List<FrontSprocketConv> frontSprocketConvList = frontSprocketConvRepository.findAll();
        assertThat(frontSprocketConvList).hasSize(databaseSizeBeforeUpdate);
        FrontSprocketConv testFrontSprocketConv = frontSprocketConvList.get(frontSprocketConvList.size() - 1);
        assertThat(testFrontSprocketConv.getSku()).isEqualTo(UPDATED_SKU);
    }

    @Test
    @Transactional
    public void updateNonExistingFrontSprocketConv() throws Exception {
        int databaseSizeBeforeUpdate = frontSprocketConvRepository.findAll().size();

        // Create the FrontSprocketConv
        FrontSprocketConvDTO frontSprocketConvDTO = frontSprocketConvMapper.toDto(frontSprocketConv);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFrontSprocketConvMockMvc.perform(put("/api/front-sprocket-convs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(frontSprocketConvDTO)))
            .andExpect(status().isBadRequest());

        // Validate the FrontSprocketConv in the database
        List<FrontSprocketConv> frontSprocketConvList = frontSprocketConvRepository.findAll();
        assertThat(frontSprocketConvList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFrontSprocketConv() throws Exception {
        // Initialize the database
        frontSprocketConvRepository.saveAndFlush(frontSprocketConv);

        int databaseSizeBeforeDelete = frontSprocketConvRepository.findAll().size();

        // Get the frontSprocketConv
        restFrontSprocketConvMockMvc.perform(delete("/api/front-sprocket-convs/{id}", frontSprocketConv.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<FrontSprocketConv> frontSprocketConvList = frontSprocketConvRepository.findAll();
        assertThat(frontSprocketConvList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FrontSprocketConv.class);
        FrontSprocketConv frontSprocketConv1 = new FrontSprocketConv();
        frontSprocketConv1.setId(1L);
        FrontSprocketConv frontSprocketConv2 = new FrontSprocketConv();
        frontSprocketConv2.setId(frontSprocketConv1.getId());
        assertThat(frontSprocketConv1).isEqualTo(frontSprocketConv2);
        frontSprocketConv2.setId(2L);
        assertThat(frontSprocketConv1).isNotEqualTo(frontSprocketConv2);
        frontSprocketConv1.setId(null);
        assertThat(frontSprocketConv1).isNotEqualTo(frontSprocketConv2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FrontSprocketConvDTO.class);
        FrontSprocketConvDTO frontSprocketConvDTO1 = new FrontSprocketConvDTO();
        frontSprocketConvDTO1.setId(1L);
        FrontSprocketConvDTO frontSprocketConvDTO2 = new FrontSprocketConvDTO();
        assertThat(frontSprocketConvDTO1).isNotEqualTo(frontSprocketConvDTO2);
        frontSprocketConvDTO2.setId(frontSprocketConvDTO1.getId());
        assertThat(frontSprocketConvDTO1).isEqualTo(frontSprocketConvDTO2);
        frontSprocketConvDTO2.setId(2L);
        assertThat(frontSprocketConvDTO1).isNotEqualTo(frontSprocketConvDTO2);
        frontSprocketConvDTO1.setId(null);
        assertThat(frontSprocketConvDTO1).isNotEqualTo(frontSprocketConvDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(frontSprocketConvMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(frontSprocketConvMapper.fromId(null)).isNull();
    }
}
