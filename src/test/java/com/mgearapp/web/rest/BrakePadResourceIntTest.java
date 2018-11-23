package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BrakePad;
import com.mgearapp.repository.BrakePadRepository;
import com.mgearapp.service.BrakePadService;
import com.mgearapp.service.dto.BrakePadDTO;
import com.mgearapp.service.mapper.BrakePadMapper;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;


import static com.mgearapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BrakePadResource REST controller.
 *
 * @see BrakePadResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BrakePadResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    private static final String DEFAULT_AU = "AAAAAAAAAA";
    private static final String UPDATED_AU = "BBBBBBBBBB";

    private static final String DEFAULT_DE = "AAAAAAAAAA";
    private static final String UPDATED_DE = "BBBBBBBBBB";

    private static final String DEFAULT_BIKEMATE_VISIBILITY = "AAAAAAAAAA";
    private static final String UPDATED_BIKEMATE_VISIBILITY = "BBBBBBBBBB";

    private static final String DEFAULT_MGI_VISIBLITY = "AAAAAAAAAA";
    private static final String UPDATED_MGI_VISIBLITY = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVE_NETO = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVE_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_GROUP_1 = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_GROUP_1 = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_GROUP_2 = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_GROUP_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FITMENT = "AAAAAAAAAA";
    private static final String UPDATED_FITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_UNIT = "AAAAAAAAAA";
    private static final String UPDATED_UNIT = "BBBBBBBBBB";

    private static final Long DEFAULT_QTY = 1L;
    private static final Long UPDATED_QTY = 2L;

    private static final String DEFAULT_BRAND = "AAAAAAAAAA";
    private static final String UPDATED_BRAND = "BBBBBBBBBB";

    private static final String DEFAULT_BIKETYPES = "AAAAAAAAAA";
    private static final String UPDATED_BIKETYPES = "BBBBBBBBBB";

    private static final String DEFAULT_MODELS_2012_ON = "AAAAAAAAAA";
    private static final String UPDATED_MODELS_2012_ON = "BBBBBBBBBB";

    private static final Long DEFAULT_G_S_1_EAN = 1L;
    private static final Long UPDATED_G_S_1_EAN = 2L;

    private static final String DEFAULT_OUR_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_OUR_NOTES = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_WEIGHTKG = new BigDecimal(1);
    private static final BigDecimal UPDATED_WEIGHTKG = new BigDecimal(2);

    private static final String DEFAULT_PACK_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PACK_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PACK_LENGTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_LENGTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_WIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_WIDTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_HEIGHT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_HEIGHT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_CUBIC = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_CUBIC = new BigDecimal(2);

    private static final String DEFAULT_CALIPER = "AAAAAAAAAA";
    private static final String UPDATED_CALIPER = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_ALENGTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_ALENGTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_AWIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_AWIDTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_ATHICKNESS = new BigDecimal(1);
    private static final BigDecimal UPDATED_ATHICKNESS = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BLENGTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_BLENGTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BWIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_BWIDTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BTHICKNESS = new BigDecimal(1);
    private static final BigDecimal UPDATED_BTHICKNESS = new BigDecimal(2);

    private static final String DEFAULT_CUSTOMER_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_E_LISTING = "AAAAAAAAAA";
    private static final String UPDATED_E_LISTING = "BBBBBBBBBB";

    private static final String DEFAULT_EFOR_MAKE = "AAAAAAAAAA";
    private static final String UPDATED_EFOR_MAKE = "BBBBBBBBBB";

    private static final String DEFAULT_EUPLOADED_NETO = "AAAAAAAAAA";
    private static final String UPDATED_EUPLOADED_NETO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_E_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_E_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ECHECK = "AAAAAAAAAA";
    private static final String UPDATED_ECHECK = "BBBBBBBBBB";

    private static final String DEFAULT_EUPLOADEDE_BAY = "AAAAAAAAAA";
    private static final String UPDATED_EUPLOADEDE_BAY = "BBBBBBBBBB";

    private static final String DEFAULT_EBAYACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_EBAYACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTOBUCKET = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTOBUCKET = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_MAIN = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_MAIN = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_CLEAR = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_CLEAR = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_SIDE = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_SIDE = "BBBBBBBBBB";

    private static final String DEFAULT_SALE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SALE_STATUS = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_R_RP = new BigDecimal(1);
    private static final BigDecimal UPDATED_R_RP = new BigDecimal(2);

    private static final BigDecimal DEFAULT_E_BAY = new BigDecimal(1);
    private static final BigDecimal UPDATED_E_BAY = new BigDecimal(2);

    private static final String DEFAULT_E_BC = "AAAAAAAAAA";
    private static final String UPDATED_E_BC = "BBBBBBBBBB";

    private static final String DEFAULT_S_BS = "AAAAAAAAAA";
    private static final String UPDATED_S_BS = "BBBBBBBBBB";

    private static final String DEFAULT_GOLDFREN = "AAAAAAAAAA";
    private static final String UPDATED_GOLDFREN = "BBBBBBBBBB";

    private static final String DEFAULT_BRAKING = "AAAAAAAAAA";
    private static final String UPDATED_BRAKING = "BBBBBBBBBB";

    private static final String DEFAULT_BREMBO = "AAAAAAAAAA";
    private static final String UPDATED_BREMBO = "BBBBBBBBBB";

    private static final String DEFAULT_FERODO = "AAAAAAAAAA";
    private static final String UPDATED_FERODO = "BBBBBBBBBB";

    private static final String DEFAULT_GOODRIDGE = "AAAAAAAAAA";
    private static final String UPDATED_GOODRIDGE = "BBBBBBBBBB";

    private static final String DEFAULT_PREMIER = "AAAAAAAAAA";
    private static final String UPDATED_PREMIER = "BBBBBBBBBB";

    private static final String DEFAULT_CARBON = "AAAAAAAAAA";
    private static final String UPDATED_CARBON = "BBBBBBBBBB";

    private static final String DEFAULT_GALFER = "AAAAAAAAAA";
    private static final String UPDATED_GALFER = "BBBBBBBBBB";

    private static final String DEFAULT_VESRAH = "AAAAAAAAAA";
    private static final String UPDATED_VESRAH = "BBBBBBBBBB";

    private static final String DEFAULT_LUCAS = "AAAAAAAAAA";
    private static final String UPDATED_LUCAS = "BBBBBBBBBB";

    private static final String DEFAULT_NEW_FREN = "AAAAAAAAAA";
    private static final String UPDATED_NEW_FREN = "BBBBBBBBBB";

    private static final String DEFAULT_DUNLOP = "AAAAAAAAAA";
    private static final String UPDATED_DUNLOP = "BBBBBBBBBB";

    private static final String DEFAULT_LOCKHEED = "AAAAAAAAAA";
    private static final String UPDATED_LOCKHEED = "BBBBBBBBBB";

    private static final String DEFAULT_BENDIX = "AAAAAAAAAA";
    private static final String UPDATED_BENDIX = "BBBBBBBBBB";

    @Autowired
    private BrakePadRepository brakePadRepository;

    @Autowired
    private BrakePadMapper brakePadMapper;
    
    @Autowired
    private BrakePadService brakePadService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBrakePadMockMvc;

    private BrakePad brakePad;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BrakePadResource brakePadResource = new BrakePadResource(brakePadService);
        this.restBrakePadMockMvc = MockMvcBuilders.standaloneSetup(brakePadResource)
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
    public static BrakePad createEntity(EntityManager em) {
        BrakePad brakePad = new BrakePad()
            .sku(DEFAULT_SKU)
            .au(DEFAULT_AU)
            .de(DEFAULT_DE)
            .bikemateVisibility(DEFAULT_BIKEMATE_VISIBILITY)
            .mgiVisiblity(DEFAULT_MGI_VISIBLITY)
            .activeNeto(DEFAULT_ACTIVE_NETO)
            .status(DEFAULT_STATUS)
            .productGroup1(DEFAULT_PRODUCT_GROUP_1)
            .productGroup2(DEFAULT_PRODUCT_GROUP_2)
            .fitment(DEFAULT_FITMENT)
            .description(DEFAULT_DESCRIPTION)
            .unit(DEFAULT_UNIT)
            .qty(DEFAULT_QTY)
            .brand(DEFAULT_BRAND)
            .biketypes(DEFAULT_BIKETYPES)
            .models2012on(DEFAULT_MODELS_2012_ON)
            .gS1EAN(DEFAULT_G_S_1_EAN)
            .ourNotes(DEFAULT_OUR_NOTES)
            .weightkg(DEFAULT_WEIGHTKG)
            .packType(DEFAULT_PACK_TYPE)
            .packLength(DEFAULT_PACK_LENGTH)
            .packWidth(DEFAULT_PACK_WIDTH)
            .packHeight(DEFAULT_PACK_HEIGHT)
            .packCubic(DEFAULT_PACK_CUBIC)
            .caliper(DEFAULT_CALIPER)
            .alength(DEFAULT_ALENGTH)
            .awidth(DEFAULT_AWIDTH)
            .athickness(DEFAULT_ATHICKNESS)
            .blength(DEFAULT_BLENGTH)
            .bwidth(DEFAULT_BWIDTH)
            .bthickness(DEFAULT_BTHICKNESS)
            .customerNotes(DEFAULT_CUSTOMER_NOTES)
            .eListing(DEFAULT_E_LISTING)
            .eforMake(DEFAULT_EFOR_MAKE)
            .euploadedNeto(DEFAULT_EUPLOADED_NETO)
            .eDate(DEFAULT_E_DATE)
            .echeck(DEFAULT_ECHECK)
            .euploadedeBay(DEFAULT_EUPLOADEDE_BAY)
            .ebayactive(DEFAULT_EBAYACTIVE)
            .ePhotobucket(DEFAULT_E_PHOTOBUCKET)
            .ePhotoMain(DEFAULT_E_PHOTO_MAIN)
            .ePhotoClear(DEFAULT_E_PHOTO_CLEAR)
            .ePhotoSide(DEFAULT_E_PHOTO_SIDE)
            .saleStatus(DEFAULT_SALE_STATUS)
            .rRP(DEFAULT_R_RP)
            .eBay(DEFAULT_E_BAY)
            .eBC(DEFAULT_E_BC)
            .sBS(DEFAULT_S_BS)
            .goldfren(DEFAULT_GOLDFREN)
            .braking(DEFAULT_BRAKING)
            .brembo(DEFAULT_BREMBO)
            .ferodo(DEFAULT_FERODO)
            .goodridge(DEFAULT_GOODRIDGE)
            .premier(DEFAULT_PREMIER)
            .carbon(DEFAULT_CARBON)
            .galfer(DEFAULT_GALFER)
            .vesrah(DEFAULT_VESRAH)
            .lucas(DEFAULT_LUCAS)
            .newFren(DEFAULT_NEW_FREN)
            .dunlop(DEFAULT_DUNLOP)
            .lockheed(DEFAULT_LOCKHEED)
            .bendix(DEFAULT_BENDIX);
        return brakePad;
    }

    @Before
    public void initTest() {
        brakePad = createEntity(em);
    }

    @Test
    @Transactional
    public void createBrakePad() throws Exception {
        int databaseSizeBeforeCreate = brakePadRepository.findAll().size();

        // Create the BrakePad
        BrakePadDTO brakePadDTO = brakePadMapper.toDto(brakePad);
        restBrakePadMockMvc.perform(post("/api/brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakePadDTO)))
            .andExpect(status().isCreated());

        // Validate the BrakePad in the database
        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeCreate + 1);
        BrakePad testBrakePad = brakePadList.get(brakePadList.size() - 1);
        assertThat(testBrakePad.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(testBrakePad.getAu()).isEqualTo(DEFAULT_AU);
        assertThat(testBrakePad.getDe()).isEqualTo(DEFAULT_DE);
        assertThat(testBrakePad.getBikemateVisibility()).isEqualTo(DEFAULT_BIKEMATE_VISIBILITY);
        assertThat(testBrakePad.getMgiVisiblity()).isEqualTo(DEFAULT_MGI_VISIBLITY);
        assertThat(testBrakePad.getActiveNeto()).isEqualTo(DEFAULT_ACTIVE_NETO);
        assertThat(testBrakePad.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testBrakePad.getProductGroup1()).isEqualTo(DEFAULT_PRODUCT_GROUP_1);
        assertThat(testBrakePad.getProductGroup2()).isEqualTo(DEFAULT_PRODUCT_GROUP_2);
        assertThat(testBrakePad.getFitment()).isEqualTo(DEFAULT_FITMENT);
        assertThat(testBrakePad.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testBrakePad.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testBrakePad.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testBrakePad.getBrand()).isEqualTo(DEFAULT_BRAND);
        assertThat(testBrakePad.getBiketypes()).isEqualTo(DEFAULT_BIKETYPES);
        assertThat(testBrakePad.getModels2012on()).isEqualTo(DEFAULT_MODELS_2012_ON);
        assertThat(testBrakePad.getgS1EAN()).isEqualTo(DEFAULT_G_S_1_EAN);
        assertThat(testBrakePad.getOurNotes()).isEqualTo(DEFAULT_OUR_NOTES);
        assertThat(testBrakePad.getWeightkg()).isEqualTo(DEFAULT_WEIGHTKG);
        assertThat(testBrakePad.getPackType()).isEqualTo(DEFAULT_PACK_TYPE);
        assertThat(testBrakePad.getPackLength()).isEqualTo(DEFAULT_PACK_LENGTH);
        assertThat(testBrakePad.getPackWidth()).isEqualTo(DEFAULT_PACK_WIDTH);
        assertThat(testBrakePad.getPackHeight()).isEqualTo(DEFAULT_PACK_HEIGHT);
        assertThat(testBrakePad.getPackCubic()).isEqualTo(DEFAULT_PACK_CUBIC);
        assertThat(testBrakePad.getCaliper()).isEqualTo(DEFAULT_CALIPER);
        assertThat(testBrakePad.getAlength()).isEqualTo(DEFAULT_ALENGTH);
        assertThat(testBrakePad.getAwidth()).isEqualTo(DEFAULT_AWIDTH);
        assertThat(testBrakePad.getAthickness()).isEqualTo(DEFAULT_ATHICKNESS);
        assertThat(testBrakePad.getBlength()).isEqualTo(DEFAULT_BLENGTH);
        assertThat(testBrakePad.getBwidth()).isEqualTo(DEFAULT_BWIDTH);
        assertThat(testBrakePad.getBthickness()).isEqualTo(DEFAULT_BTHICKNESS);
        assertThat(testBrakePad.getCustomerNotes()).isEqualTo(DEFAULT_CUSTOMER_NOTES);
        assertThat(testBrakePad.geteListing()).isEqualTo(DEFAULT_E_LISTING);
        assertThat(testBrakePad.getEforMake()).isEqualTo(DEFAULT_EFOR_MAKE);
        assertThat(testBrakePad.getEuploadedNeto()).isEqualTo(DEFAULT_EUPLOADED_NETO);
        assertThat(testBrakePad.geteDate()).isEqualTo(DEFAULT_E_DATE);
        assertThat(testBrakePad.getEcheck()).isEqualTo(DEFAULT_ECHECK);
        assertThat(testBrakePad.getEuploadedeBay()).isEqualTo(DEFAULT_EUPLOADEDE_BAY);
        assertThat(testBrakePad.getEbayactive()).isEqualTo(DEFAULT_EBAYACTIVE);
        assertThat(testBrakePad.getePhotobucket()).isEqualTo(DEFAULT_E_PHOTOBUCKET);
        assertThat(testBrakePad.getePhotoMain()).isEqualTo(DEFAULT_E_PHOTO_MAIN);
        assertThat(testBrakePad.getePhotoClear()).isEqualTo(DEFAULT_E_PHOTO_CLEAR);
        assertThat(testBrakePad.getePhotoSide()).isEqualTo(DEFAULT_E_PHOTO_SIDE);
        assertThat(testBrakePad.getSaleStatus()).isEqualTo(DEFAULT_SALE_STATUS);
        assertThat(testBrakePad.getrRP()).isEqualTo(DEFAULT_R_RP);
        assertThat(testBrakePad.geteBay()).isEqualTo(DEFAULT_E_BAY);
        assertThat(testBrakePad.geteBC()).isEqualTo(DEFAULT_E_BC);
        assertThat(testBrakePad.getsBS()).isEqualTo(DEFAULT_S_BS);
        assertThat(testBrakePad.getGoldfren()).isEqualTo(DEFAULT_GOLDFREN);
        assertThat(testBrakePad.getBraking()).isEqualTo(DEFAULT_BRAKING);
        assertThat(testBrakePad.getBrembo()).isEqualTo(DEFAULT_BREMBO);
        assertThat(testBrakePad.getFerodo()).isEqualTo(DEFAULT_FERODO);
        assertThat(testBrakePad.getGoodridge()).isEqualTo(DEFAULT_GOODRIDGE);
        assertThat(testBrakePad.getPremier()).isEqualTo(DEFAULT_PREMIER);
        assertThat(testBrakePad.getCarbon()).isEqualTo(DEFAULT_CARBON);
        assertThat(testBrakePad.getGalfer()).isEqualTo(DEFAULT_GALFER);
        assertThat(testBrakePad.getVesrah()).isEqualTo(DEFAULT_VESRAH);
        assertThat(testBrakePad.getLucas()).isEqualTo(DEFAULT_LUCAS);
        assertThat(testBrakePad.getNewFren()).isEqualTo(DEFAULT_NEW_FREN);
        assertThat(testBrakePad.getDunlop()).isEqualTo(DEFAULT_DUNLOP);
        assertThat(testBrakePad.getLockheed()).isEqualTo(DEFAULT_LOCKHEED);
        assertThat(testBrakePad.getBendix()).isEqualTo(DEFAULT_BENDIX);
    }

    @Test
    @Transactional
    public void createBrakePadWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = brakePadRepository.findAll().size();

        // Create the BrakePad with an existing ID
        brakePad.setId(1L);
        BrakePadDTO brakePadDTO = brakePadMapper.toDto(brakePad);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBrakePadMockMvc.perform(post("/api/brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakePadDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BrakePad in the database
        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSkuIsRequired() throws Exception {
        int databaseSizeBeforeTest = brakePadRepository.findAll().size();
        // set the field null
        brakePad.setSku(null);

        // Create the BrakePad, which fails.
        BrakePadDTO brakePadDTO = brakePadMapper.toDto(brakePad);

        restBrakePadMockMvc.perform(post("/api/brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakePadDTO)))
            .andExpect(status().isBadRequest());

        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBrakePads() throws Exception {
        // Initialize the database
        brakePadRepository.saveAndFlush(brakePad);

        // Get all the brakePadList
        restBrakePadMockMvc.perform(get("/api/brake-pads?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(brakePad.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())))
            .andExpect(jsonPath("$.[*].au").value(hasItem(DEFAULT_AU.toString())))
            .andExpect(jsonPath("$.[*].de").value(hasItem(DEFAULT_DE.toString())))
            .andExpect(jsonPath("$.[*].bikemateVisibility").value(hasItem(DEFAULT_BIKEMATE_VISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].mgiVisiblity").value(hasItem(DEFAULT_MGI_VISIBLITY.toString())))
            .andExpect(jsonPath("$.[*].activeNeto").value(hasItem(DEFAULT_ACTIVE_NETO.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].productGroup1").value(hasItem(DEFAULT_PRODUCT_GROUP_1.toString())))
            .andExpect(jsonPath("$.[*].productGroup2").value(hasItem(DEFAULT_PRODUCT_GROUP_2.toString())))
            .andExpect(jsonPath("$.[*].fitment").value(hasItem(DEFAULT_FITMENT.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.toString())))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY.intValue())))
            .andExpect(jsonPath("$.[*].brand").value(hasItem(DEFAULT_BRAND.toString())))
            .andExpect(jsonPath("$.[*].biketypes").value(hasItem(DEFAULT_BIKETYPES.toString())))
            .andExpect(jsonPath("$.[*].models2012on").value(hasItem(DEFAULT_MODELS_2012_ON.toString())))
            .andExpect(jsonPath("$.[*].gS1EAN").value(hasItem(DEFAULT_G_S_1_EAN.intValue())))
            .andExpect(jsonPath("$.[*].ourNotes").value(hasItem(DEFAULT_OUR_NOTES.toString())))
            .andExpect(jsonPath("$.[*].weightkg").value(hasItem(DEFAULT_WEIGHTKG.intValue())))
            .andExpect(jsonPath("$.[*].packType").value(hasItem(DEFAULT_PACK_TYPE.toString())))
            .andExpect(jsonPath("$.[*].packLength").value(hasItem(DEFAULT_PACK_LENGTH.intValue())))
            .andExpect(jsonPath("$.[*].packWidth").value(hasItem(DEFAULT_PACK_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].packHeight").value(hasItem(DEFAULT_PACK_HEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].packCubic").value(hasItem(DEFAULT_PACK_CUBIC.intValue())))
            .andExpect(jsonPath("$.[*].caliper").value(hasItem(DEFAULT_CALIPER.toString())))
            .andExpect(jsonPath("$.[*].alength").value(hasItem(DEFAULT_ALENGTH.intValue())))
            .andExpect(jsonPath("$.[*].awidth").value(hasItem(DEFAULT_AWIDTH.intValue())))
            .andExpect(jsonPath("$.[*].athickness").value(hasItem(DEFAULT_ATHICKNESS.intValue())))
            .andExpect(jsonPath("$.[*].blength").value(hasItem(DEFAULT_BLENGTH.intValue())))
            .andExpect(jsonPath("$.[*].bwidth").value(hasItem(DEFAULT_BWIDTH.intValue())))
            .andExpect(jsonPath("$.[*].bthickness").value(hasItem(DEFAULT_BTHICKNESS.intValue())))
            .andExpect(jsonPath("$.[*].customerNotes").value(hasItem(DEFAULT_CUSTOMER_NOTES.toString())))
            .andExpect(jsonPath("$.[*].eListing").value(hasItem(DEFAULT_E_LISTING.toString())))
            .andExpect(jsonPath("$.[*].eforMake").value(hasItem(DEFAULT_EFOR_MAKE.toString())))
            .andExpect(jsonPath("$.[*].euploadedNeto").value(hasItem(DEFAULT_EUPLOADED_NETO.toString())))
            .andExpect(jsonPath("$.[*].eDate").value(hasItem(DEFAULT_E_DATE.toString())))
            .andExpect(jsonPath("$.[*].echeck").value(hasItem(DEFAULT_ECHECK.toString())))
            .andExpect(jsonPath("$.[*].euploadedeBay").value(hasItem(DEFAULT_EUPLOADEDE_BAY.toString())))
            .andExpect(jsonPath("$.[*].ebayactive").value(hasItem(DEFAULT_EBAYACTIVE.toString())))
            .andExpect(jsonPath("$.[*].ePhotobucket").value(hasItem(DEFAULT_E_PHOTOBUCKET.toString())))
            .andExpect(jsonPath("$.[*].ePhotoMain").value(hasItem(DEFAULT_E_PHOTO_MAIN.toString())))
            .andExpect(jsonPath("$.[*].ePhotoClear").value(hasItem(DEFAULT_E_PHOTO_CLEAR.toString())))
            .andExpect(jsonPath("$.[*].ePhotoSide").value(hasItem(DEFAULT_E_PHOTO_SIDE.toString())))
            .andExpect(jsonPath("$.[*].saleStatus").value(hasItem(DEFAULT_SALE_STATUS.toString())))
            .andExpect(jsonPath("$.[*].rRP").value(hasItem(DEFAULT_R_RP.intValue())))
            .andExpect(jsonPath("$.[*].eBay").value(hasItem(DEFAULT_E_BAY.intValue())))
            .andExpect(jsonPath("$.[*].eBC").value(hasItem(DEFAULT_E_BC.toString())))
            .andExpect(jsonPath("$.[*].sBS").value(hasItem(DEFAULT_S_BS.toString())))
            .andExpect(jsonPath("$.[*].goldfren").value(hasItem(DEFAULT_GOLDFREN.toString())))
            .andExpect(jsonPath("$.[*].braking").value(hasItem(DEFAULT_BRAKING.toString())))
            .andExpect(jsonPath("$.[*].brembo").value(hasItem(DEFAULT_BREMBO.toString())))
            .andExpect(jsonPath("$.[*].ferodo").value(hasItem(DEFAULT_FERODO.toString())))
            .andExpect(jsonPath("$.[*].goodridge").value(hasItem(DEFAULT_GOODRIDGE.toString())))
            .andExpect(jsonPath("$.[*].premier").value(hasItem(DEFAULT_PREMIER.toString())))
            .andExpect(jsonPath("$.[*].carbon").value(hasItem(DEFAULT_CARBON.toString())))
            .andExpect(jsonPath("$.[*].galfer").value(hasItem(DEFAULT_GALFER.toString())))
            .andExpect(jsonPath("$.[*].vesrah").value(hasItem(DEFAULT_VESRAH.toString())))
            .andExpect(jsonPath("$.[*].lucas").value(hasItem(DEFAULT_LUCAS.toString())))
            .andExpect(jsonPath("$.[*].newFren").value(hasItem(DEFAULT_NEW_FREN.toString())))
            .andExpect(jsonPath("$.[*].dunlop").value(hasItem(DEFAULT_DUNLOP.toString())))
            .andExpect(jsonPath("$.[*].lockheed").value(hasItem(DEFAULT_LOCKHEED.toString())))
            .andExpect(jsonPath("$.[*].bendix").value(hasItem(DEFAULT_BENDIX.toString())));
    }
    
    @Test
    @Transactional
    public void getBrakePad() throws Exception {
        // Initialize the database
        brakePadRepository.saveAndFlush(brakePad);

        // Get the brakePad
        restBrakePadMockMvc.perform(get("/api/brake-pads/{id}", brakePad.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(brakePad.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()))
            .andExpect(jsonPath("$.au").value(DEFAULT_AU.toString()))
            .andExpect(jsonPath("$.de").value(DEFAULT_DE.toString()))
            .andExpect(jsonPath("$.bikemateVisibility").value(DEFAULT_BIKEMATE_VISIBILITY.toString()))
            .andExpect(jsonPath("$.mgiVisiblity").value(DEFAULT_MGI_VISIBLITY.toString()))
            .andExpect(jsonPath("$.activeNeto").value(DEFAULT_ACTIVE_NETO.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.productGroup1").value(DEFAULT_PRODUCT_GROUP_1.toString()))
            .andExpect(jsonPath("$.productGroup2").value(DEFAULT_PRODUCT_GROUP_2.toString()))
            .andExpect(jsonPath("$.fitment").value(DEFAULT_FITMENT.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.toString()))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY.intValue()))
            .andExpect(jsonPath("$.brand").value(DEFAULT_BRAND.toString()))
            .andExpect(jsonPath("$.biketypes").value(DEFAULT_BIKETYPES.toString()))
            .andExpect(jsonPath("$.models2012on").value(DEFAULT_MODELS_2012_ON.toString()))
            .andExpect(jsonPath("$.gS1EAN").value(DEFAULT_G_S_1_EAN.intValue()))
            .andExpect(jsonPath("$.ourNotes").value(DEFAULT_OUR_NOTES.toString()))
            .andExpect(jsonPath("$.weightkg").value(DEFAULT_WEIGHTKG.intValue()))
            .andExpect(jsonPath("$.packType").value(DEFAULT_PACK_TYPE.toString()))
            .andExpect(jsonPath("$.packLength").value(DEFAULT_PACK_LENGTH.intValue()))
            .andExpect(jsonPath("$.packWidth").value(DEFAULT_PACK_WIDTH.intValue()))
            .andExpect(jsonPath("$.packHeight").value(DEFAULT_PACK_HEIGHT.intValue()))
            .andExpect(jsonPath("$.packCubic").value(DEFAULT_PACK_CUBIC.intValue()))
            .andExpect(jsonPath("$.caliper").value(DEFAULT_CALIPER.toString()))
            .andExpect(jsonPath("$.alength").value(DEFAULT_ALENGTH.intValue()))
            .andExpect(jsonPath("$.awidth").value(DEFAULT_AWIDTH.intValue()))
            .andExpect(jsonPath("$.athickness").value(DEFAULT_ATHICKNESS.intValue()))
            .andExpect(jsonPath("$.blength").value(DEFAULT_BLENGTH.intValue()))
            .andExpect(jsonPath("$.bwidth").value(DEFAULT_BWIDTH.intValue()))
            .andExpect(jsonPath("$.bthickness").value(DEFAULT_BTHICKNESS.intValue()))
            .andExpect(jsonPath("$.customerNotes").value(DEFAULT_CUSTOMER_NOTES.toString()))
            .andExpect(jsonPath("$.eListing").value(DEFAULT_E_LISTING.toString()))
            .andExpect(jsonPath("$.eforMake").value(DEFAULT_EFOR_MAKE.toString()))
            .andExpect(jsonPath("$.euploadedNeto").value(DEFAULT_EUPLOADED_NETO.toString()))
            .andExpect(jsonPath("$.eDate").value(DEFAULT_E_DATE.toString()))
            .andExpect(jsonPath("$.echeck").value(DEFAULT_ECHECK.toString()))
            .andExpect(jsonPath("$.euploadedeBay").value(DEFAULT_EUPLOADEDE_BAY.toString()))
            .andExpect(jsonPath("$.ebayactive").value(DEFAULT_EBAYACTIVE.toString()))
            .andExpect(jsonPath("$.ePhotobucket").value(DEFAULT_E_PHOTOBUCKET.toString()))
            .andExpect(jsonPath("$.ePhotoMain").value(DEFAULT_E_PHOTO_MAIN.toString()))
            .andExpect(jsonPath("$.ePhotoClear").value(DEFAULT_E_PHOTO_CLEAR.toString()))
            .andExpect(jsonPath("$.ePhotoSide").value(DEFAULT_E_PHOTO_SIDE.toString()))
            .andExpect(jsonPath("$.saleStatus").value(DEFAULT_SALE_STATUS.toString()))
            .andExpect(jsonPath("$.rRP").value(DEFAULT_R_RP.intValue()))
            .andExpect(jsonPath("$.eBay").value(DEFAULT_E_BAY.intValue()))
            .andExpect(jsonPath("$.eBC").value(DEFAULT_E_BC.toString()))
            .andExpect(jsonPath("$.sBS").value(DEFAULT_S_BS.toString()))
            .andExpect(jsonPath("$.goldfren").value(DEFAULT_GOLDFREN.toString()))
            .andExpect(jsonPath("$.braking").value(DEFAULT_BRAKING.toString()))
            .andExpect(jsonPath("$.brembo").value(DEFAULT_BREMBO.toString()))
            .andExpect(jsonPath("$.ferodo").value(DEFAULT_FERODO.toString()))
            .andExpect(jsonPath("$.goodridge").value(DEFAULT_GOODRIDGE.toString()))
            .andExpect(jsonPath("$.premier").value(DEFAULT_PREMIER.toString()))
            .andExpect(jsonPath("$.carbon").value(DEFAULT_CARBON.toString()))
            .andExpect(jsonPath("$.galfer").value(DEFAULT_GALFER.toString()))
            .andExpect(jsonPath("$.vesrah").value(DEFAULT_VESRAH.toString()))
            .andExpect(jsonPath("$.lucas").value(DEFAULT_LUCAS.toString()))
            .andExpect(jsonPath("$.newFren").value(DEFAULT_NEW_FREN.toString()))
            .andExpect(jsonPath("$.dunlop").value(DEFAULT_DUNLOP.toString()))
            .andExpect(jsonPath("$.lockheed").value(DEFAULT_LOCKHEED.toString()))
            .andExpect(jsonPath("$.bendix").value(DEFAULT_BENDIX.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBrakePad() throws Exception {
        // Get the brakePad
        restBrakePadMockMvc.perform(get("/api/brake-pads/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBrakePad() throws Exception {
        // Initialize the database
        brakePadRepository.saveAndFlush(brakePad);

        int databaseSizeBeforeUpdate = brakePadRepository.findAll().size();

        // Update the brakePad
        BrakePad updatedBrakePad = brakePadRepository.findById(brakePad.getId()).get();
        // Disconnect from session so that the updates on updatedBrakePad are not directly saved in db
        em.detach(updatedBrakePad);
        updatedBrakePad
            .sku(UPDATED_SKU)
            .au(UPDATED_AU)
            .de(UPDATED_DE)
            .bikemateVisibility(UPDATED_BIKEMATE_VISIBILITY)
            .mgiVisiblity(UPDATED_MGI_VISIBLITY)
            .activeNeto(UPDATED_ACTIVE_NETO)
            .status(UPDATED_STATUS)
            .productGroup1(UPDATED_PRODUCT_GROUP_1)
            .productGroup2(UPDATED_PRODUCT_GROUP_2)
            .fitment(UPDATED_FITMENT)
            .description(UPDATED_DESCRIPTION)
            .unit(UPDATED_UNIT)
            .qty(UPDATED_QTY)
            .brand(UPDATED_BRAND)
            .biketypes(UPDATED_BIKETYPES)
            .models2012on(UPDATED_MODELS_2012_ON)
            .gS1EAN(UPDATED_G_S_1_EAN)
            .ourNotes(UPDATED_OUR_NOTES)
            .weightkg(UPDATED_WEIGHTKG)
            .packType(UPDATED_PACK_TYPE)
            .packLength(UPDATED_PACK_LENGTH)
            .packWidth(UPDATED_PACK_WIDTH)
            .packHeight(UPDATED_PACK_HEIGHT)
            .packCubic(UPDATED_PACK_CUBIC)
            .caliper(UPDATED_CALIPER)
            .alength(UPDATED_ALENGTH)
            .awidth(UPDATED_AWIDTH)
            .athickness(UPDATED_ATHICKNESS)
            .blength(UPDATED_BLENGTH)
            .bwidth(UPDATED_BWIDTH)
            .bthickness(UPDATED_BTHICKNESS)
            .customerNotes(UPDATED_CUSTOMER_NOTES)
            .eListing(UPDATED_E_LISTING)
            .eforMake(UPDATED_EFOR_MAKE)
            .euploadedNeto(UPDATED_EUPLOADED_NETO)
            .eDate(UPDATED_E_DATE)
            .echeck(UPDATED_ECHECK)
            .euploadedeBay(UPDATED_EUPLOADEDE_BAY)
            .ebayactive(UPDATED_EBAYACTIVE)
            .ePhotobucket(UPDATED_E_PHOTOBUCKET)
            .ePhotoMain(UPDATED_E_PHOTO_MAIN)
            .ePhotoClear(UPDATED_E_PHOTO_CLEAR)
            .ePhotoSide(UPDATED_E_PHOTO_SIDE)
            .saleStatus(UPDATED_SALE_STATUS)
            .rRP(UPDATED_R_RP)
            .eBay(UPDATED_E_BAY)
            .eBC(UPDATED_E_BC)
            .sBS(UPDATED_S_BS)
            .goldfren(UPDATED_GOLDFREN)
            .braking(UPDATED_BRAKING)
            .brembo(UPDATED_BREMBO)
            .ferodo(UPDATED_FERODO)
            .goodridge(UPDATED_GOODRIDGE)
            .premier(UPDATED_PREMIER)
            .carbon(UPDATED_CARBON)
            .galfer(UPDATED_GALFER)
            .vesrah(UPDATED_VESRAH)
            .lucas(UPDATED_LUCAS)
            .newFren(UPDATED_NEW_FREN)
            .dunlop(UPDATED_DUNLOP)
            .lockheed(UPDATED_LOCKHEED)
            .bendix(UPDATED_BENDIX);
        BrakePadDTO brakePadDTO = brakePadMapper.toDto(updatedBrakePad);

        restBrakePadMockMvc.perform(put("/api/brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakePadDTO)))
            .andExpect(status().isOk());

        // Validate the BrakePad in the database
        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeUpdate);
        BrakePad testBrakePad = brakePadList.get(brakePadList.size() - 1);
        assertThat(testBrakePad.getSku()).isEqualTo(UPDATED_SKU);
        assertThat(testBrakePad.getAu()).isEqualTo(UPDATED_AU);
        assertThat(testBrakePad.getDe()).isEqualTo(UPDATED_DE);
        assertThat(testBrakePad.getBikemateVisibility()).isEqualTo(UPDATED_BIKEMATE_VISIBILITY);
        assertThat(testBrakePad.getMgiVisiblity()).isEqualTo(UPDATED_MGI_VISIBLITY);
        assertThat(testBrakePad.getActiveNeto()).isEqualTo(UPDATED_ACTIVE_NETO);
        assertThat(testBrakePad.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testBrakePad.getProductGroup1()).isEqualTo(UPDATED_PRODUCT_GROUP_1);
        assertThat(testBrakePad.getProductGroup2()).isEqualTo(UPDATED_PRODUCT_GROUP_2);
        assertThat(testBrakePad.getFitment()).isEqualTo(UPDATED_FITMENT);
        assertThat(testBrakePad.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testBrakePad.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testBrakePad.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testBrakePad.getBrand()).isEqualTo(UPDATED_BRAND);
        assertThat(testBrakePad.getBiketypes()).isEqualTo(UPDATED_BIKETYPES);
        assertThat(testBrakePad.getModels2012on()).isEqualTo(UPDATED_MODELS_2012_ON);
        assertThat(testBrakePad.getgS1EAN()).isEqualTo(UPDATED_G_S_1_EAN);
        assertThat(testBrakePad.getOurNotes()).isEqualTo(UPDATED_OUR_NOTES);
        assertThat(testBrakePad.getWeightkg()).isEqualTo(UPDATED_WEIGHTKG);
        assertThat(testBrakePad.getPackType()).isEqualTo(UPDATED_PACK_TYPE);
        assertThat(testBrakePad.getPackLength()).isEqualTo(UPDATED_PACK_LENGTH);
        assertThat(testBrakePad.getPackWidth()).isEqualTo(UPDATED_PACK_WIDTH);
        assertThat(testBrakePad.getPackHeight()).isEqualTo(UPDATED_PACK_HEIGHT);
        assertThat(testBrakePad.getPackCubic()).isEqualTo(UPDATED_PACK_CUBIC);
        assertThat(testBrakePad.getCaliper()).isEqualTo(UPDATED_CALIPER);
        assertThat(testBrakePad.getAlength()).isEqualTo(UPDATED_ALENGTH);
        assertThat(testBrakePad.getAwidth()).isEqualTo(UPDATED_AWIDTH);
        assertThat(testBrakePad.getAthickness()).isEqualTo(UPDATED_ATHICKNESS);
        assertThat(testBrakePad.getBlength()).isEqualTo(UPDATED_BLENGTH);
        assertThat(testBrakePad.getBwidth()).isEqualTo(UPDATED_BWIDTH);
        assertThat(testBrakePad.getBthickness()).isEqualTo(UPDATED_BTHICKNESS);
        assertThat(testBrakePad.getCustomerNotes()).isEqualTo(UPDATED_CUSTOMER_NOTES);
        assertThat(testBrakePad.geteListing()).isEqualTo(UPDATED_E_LISTING);
        assertThat(testBrakePad.getEforMake()).isEqualTo(UPDATED_EFOR_MAKE);
        assertThat(testBrakePad.getEuploadedNeto()).isEqualTo(UPDATED_EUPLOADED_NETO);
        assertThat(testBrakePad.geteDate()).isEqualTo(UPDATED_E_DATE);
        assertThat(testBrakePad.getEcheck()).isEqualTo(UPDATED_ECHECK);
        assertThat(testBrakePad.getEuploadedeBay()).isEqualTo(UPDATED_EUPLOADEDE_BAY);
        assertThat(testBrakePad.getEbayactive()).isEqualTo(UPDATED_EBAYACTIVE);
        assertThat(testBrakePad.getePhotobucket()).isEqualTo(UPDATED_E_PHOTOBUCKET);
        assertThat(testBrakePad.getePhotoMain()).isEqualTo(UPDATED_E_PHOTO_MAIN);
        assertThat(testBrakePad.getePhotoClear()).isEqualTo(UPDATED_E_PHOTO_CLEAR);
        assertThat(testBrakePad.getePhotoSide()).isEqualTo(UPDATED_E_PHOTO_SIDE);
        assertThat(testBrakePad.getSaleStatus()).isEqualTo(UPDATED_SALE_STATUS);
        assertThat(testBrakePad.getrRP()).isEqualTo(UPDATED_R_RP);
        assertThat(testBrakePad.geteBay()).isEqualTo(UPDATED_E_BAY);
        assertThat(testBrakePad.geteBC()).isEqualTo(UPDATED_E_BC);
        assertThat(testBrakePad.getsBS()).isEqualTo(UPDATED_S_BS);
        assertThat(testBrakePad.getGoldfren()).isEqualTo(UPDATED_GOLDFREN);
        assertThat(testBrakePad.getBraking()).isEqualTo(UPDATED_BRAKING);
        assertThat(testBrakePad.getBrembo()).isEqualTo(UPDATED_BREMBO);
        assertThat(testBrakePad.getFerodo()).isEqualTo(UPDATED_FERODO);
        assertThat(testBrakePad.getGoodridge()).isEqualTo(UPDATED_GOODRIDGE);
        assertThat(testBrakePad.getPremier()).isEqualTo(UPDATED_PREMIER);
        assertThat(testBrakePad.getCarbon()).isEqualTo(UPDATED_CARBON);
        assertThat(testBrakePad.getGalfer()).isEqualTo(UPDATED_GALFER);
        assertThat(testBrakePad.getVesrah()).isEqualTo(UPDATED_VESRAH);
        assertThat(testBrakePad.getLucas()).isEqualTo(UPDATED_LUCAS);
        assertThat(testBrakePad.getNewFren()).isEqualTo(UPDATED_NEW_FREN);
        assertThat(testBrakePad.getDunlop()).isEqualTo(UPDATED_DUNLOP);
        assertThat(testBrakePad.getLockheed()).isEqualTo(UPDATED_LOCKHEED);
        assertThat(testBrakePad.getBendix()).isEqualTo(UPDATED_BENDIX);
    }

    @Test
    @Transactional
    public void updateNonExistingBrakePad() throws Exception {
        int databaseSizeBeforeUpdate = brakePadRepository.findAll().size();

        // Create the BrakePad
        BrakePadDTO brakePadDTO = brakePadMapper.toDto(brakePad);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBrakePadMockMvc.perform(put("/api/brake-pads")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakePadDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BrakePad in the database
        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBrakePad() throws Exception {
        // Initialize the database
        brakePadRepository.saveAndFlush(brakePad);

        int databaseSizeBeforeDelete = brakePadRepository.findAll().size();

        // Get the brakePad
        restBrakePadMockMvc.perform(delete("/api/brake-pads/{id}", brakePad.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BrakePad> brakePadList = brakePadRepository.findAll();
        assertThat(brakePadList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BrakePad.class);
        BrakePad brakePad1 = new BrakePad();
        brakePad1.setId(1L);
        BrakePad brakePad2 = new BrakePad();
        brakePad2.setId(brakePad1.getId());
        assertThat(brakePad1).isEqualTo(brakePad2);
        brakePad2.setId(2L);
        assertThat(brakePad1).isNotEqualTo(brakePad2);
        brakePad1.setId(null);
        assertThat(brakePad1).isNotEqualTo(brakePad2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BrakePadDTO.class);
        BrakePadDTO brakePadDTO1 = new BrakePadDTO();
        brakePadDTO1.setId(1L);
        BrakePadDTO brakePadDTO2 = new BrakePadDTO();
        assertThat(brakePadDTO1).isNotEqualTo(brakePadDTO2);
        brakePadDTO2.setId(brakePadDTO1.getId());
        assertThat(brakePadDTO1).isEqualTo(brakePadDTO2);
        brakePadDTO2.setId(2L);
        assertThat(brakePadDTO1).isNotEqualTo(brakePadDTO2);
        brakePadDTO1.setId(null);
        assertThat(brakePadDTO1).isNotEqualTo(brakePadDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(brakePadMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(brakePadMapper.fromId(null)).isNull();
    }
}
