package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.BrakeDisc;
import com.mgearapp.repository.BrakeDiscRepository;
import com.mgearapp.service.BrakeDiscService;
import com.mgearapp.service.dto.BrakeDiscDTO;
import com.mgearapp.service.mapper.BrakeDiscMapper;
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
 * Test class for the BrakeDiscResource REST controller.
 *
 * @see BrakeDiscResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BrakeDiscResourceIntTest {

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_AU = "AAAAAAAAAA";
    private static final String UPDATED_AU = "BBBBBBBBBB";

    private static final String DEFAULT_DE = "AAAAAAAAAA";
    private static final String UPDATED_DE = "BBBBBBBBBB";

    private static final String DEFAULT_METAL_GEARVISIBILITY = "AAAAAAAAAA";
    private static final String UPDATED_METAL_GEARVISIBILITY = "BBBBBBBBBB";

    private static final String DEFAULT_BIKEMATEVISIBILITY = "AAAAAAAAAA";
    private static final String UPDATED_BIKEMATEVISIBILITY = "BBBBBBBBBB";

    private static final String DEFAULT_MGI_VISIBILITY = "AAAAAAAAAA";
    private static final String UPDATED_MGI_VISIBILITY = "BBBBBBBBBB";

    private static final String DEFAULT_DISC_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_DISC_STATUS = "BBBBBBBBBB";

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

    private static final Long DEFAULT_G_S_1_EAN_NO = 1L;
    private static final Long UPDATED_G_S_1_EAN_NO = 2L;

    private static final String DEFAULT_OUR_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_OUR_NOTES = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_WEIGHT = new BigDecimal(1);
    private static final BigDecimal UPDATED_WEIGHT = new BigDecimal(2);

    private static final String DEFAULT_PACK_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_PACK_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PACK_LENGTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_LENGTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_HEIGHT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_HEIGHT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_WIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_WIDTH = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_CUBIC = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_CUBIC = new BigDecimal(2);

    private static final Long DEFAULT_O_D = 1L;
    private static final Long UPDATED_O_D = 2L;

    private static final String DEFAULT_B_HC = "AAAAAAAAAA";
    private static final String UPDATED_B_HC = "BBBBBBBBBB";

    private static final Long DEFAULT_B_H_QTY = 1L;
    private static final Long UPDATED_B_H_QTY = 2L;

    private static final BigDecimal DEFAULT_B_H_SIZE = new BigDecimal(1);
    private static final BigDecimal UPDATED_B_H_SIZE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_B_HOD = new BigDecimal(1);
    private static final BigDecimal UPDATED_B_HOD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_B_H_STEP = new BigDecimal(1);
    private static final BigDecimal UPDATED_B_H_STEP = new BigDecimal(2);

    private static final String DEFAULT_B_H_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_B_H_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_THICKNESS = new BigDecimal(1);
    private static final BigDecimal UPDATED_THICKNESS = new BigDecimal(2);

    private static final BigDecimal DEFAULT_THICKNESS_MIN = new BigDecimal(1);
    private static final BigDecimal UPDATED_THICKNESS_MIN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OFFSET = new BigDecimal(1);
    private static final BigDecimal UPDATED_OFFSET = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BRAKE_AREAWIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_BRAKE_AREAWIDTH = new BigDecimal(2);

    private static final String DEFAULT_T_UVLHC = "AAAAAAAAAA";
    private static final String UPDATED_T_UVLHC = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_E_LISTING = "AAAAAAAAAA";
    private static final String UPDATED_E_LISTING = "BBBBBBBBBB";

    private static final String DEFAULT_EFOR_MAKE = "AAAAAAAAAA";
    private static final String UPDATED_EFOR_MAKE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_E_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_E_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_EUPLOADED_NETO = "AAAAAAAAAA";
    private static final String UPDATED_EUPLOADED_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_ECHECK = "AAAAAAAAAA";
    private static final String UPDATED_ECHECK = "BBBBBBBBBB";

    private static final String DEFAULT_EUPLOADEDE_BAY = "AAAAAAAAAA";
    private static final String UPDATED_EUPLOADEDE_BAY = "BBBBBBBBBB";

    private static final String DEFAULT_EBAYACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_EBAYACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTOBUCKET = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTOBUCKET = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_1 = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_1 = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_2 = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_2 = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_3 = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_3 = "BBBBBBBBBB";

    private static final String DEFAULT_SALE_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SALE_STATUS = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_R_RP = new BigDecimal(1);
    private static final BigDecimal UPDATED_R_RP = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_1 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_1 = new BigDecimal(2);

    private static final BigDecimal DEFAULT_E_BAY = new BigDecimal(1);
    private static final BigDecimal UPDATED_E_BAY = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_2 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_2 = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_3 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_3 = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISTRIBUTOR_NZAUD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISTRIBUTOR_NZAUD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISTRIBUTOR_EUR = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISTRIBUTOR_EUR = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISTRIBUTOR_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISTRIBUTOR_USD = new BigDecimal(2);

    private static final String DEFAULT_S_PRIORITY = "AAAAAAAAAA";
    private static final String UPDATED_S_PRIORITY = "BBBBBBBBBB";

    private static final String DEFAULT_SAMPLEFROM = "AAAAAAAAAA";
    private static final String UPDATED_SAMPLEFROM = "BBBBBBBBBB";

    private static final String DEFAULT_REQUESTEDFROM = "AAAAAAAAAA";
    private static final String UPDATED_REQUESTEDFROM = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_RECEIVED = "AAAAAAAAAA";
    private static final String UPDATED_RECEIVED = "BBBBBBBBBB";

    private static final String DEFAULT_CAMEFROM = "AAAAAAAAAA";
    private static final String UPDATED_CAMEFROM = "BBBBBBBBBB";

    private static final String DEFAULT_PAIDFOR = "AAAAAAAAAA";
    private static final String UPDATED_PAIDFOR = "BBBBBBBBBB";

    private static final String DEFAULT_SENTTO = "AAAAAAAAAA";
    private static final String UPDATED_SENTTO = "BBBBBBBBBB";

    private static final Long DEFAULT_SHIP_NO = 1L;
    private static final Long UPDATED_SHIP_NO = 2L;

    private static final LocalDate DEFAULT_DATESENT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATESENT = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_SAMPLERETURN = "AAAAAAAAAA";
    private static final String UPDATED_SAMPLERETURN = "BBBBBBBBBB";

    private static final String DEFAULT_MAKE = "AAAAAAAAAA";
    private static final String UPDATED_MAKE = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL = "AAAAAAAAAA";
    private static final String UPDATED_MODEL = "BBBBBBBBBB";

    private static final String DEFAULT_YEAR = "AAAAAAAAAA";
    private static final String UPDATED_YEAR = "BBBBBBBBBB";

    private static final String DEFAULT_SAMPLE_FITMENT = "AAAAAAAAAA";
    private static final String UPDATED_SAMPLE_FITMENT = "BBBBBBBBBB";

    private static final String DEFAULT_O_EM = "AAAAAAAAAA";
    private static final String UPDATED_O_EM = "BBBBBBBBBB";

    private static final String DEFAULT_NOTESFOR_PRODUCTION = "AAAAAAAAAA";
    private static final String UPDATED_NOTESFOR_PRODUCTION = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCTION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCTION_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_H_A_PAPPROVED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_H_A_PAPPROVED = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_S_H_AAPPROVED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_S_H_AAPPROVED = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_APPROVEDBY = "AAAAAAAAAA";
    private static final String UPDATED_APPROVEDBY = "BBBBBBBBBB";

    private static final String DEFAULT_NOTESTO_DRAWING = "AAAAAAAAAA";
    private static final String UPDATED_NOTESTO_DRAWING = "BBBBBBBBBB";

    private static final String DEFAULT_FILENAME = "AAAAAAAAAA";
    private static final String UPDATED_FILENAME = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_C_OSTUSD = new BigDecimal(1);
    private static final BigDecimal UPDATED_C_OSTUSD = new BigDecimal(2);

    private static final String DEFAULT_CENTRECOLOUR = "AAAAAAAAAA";
    private static final String UPDATED_CENTRECOLOUR = "BBBBBBBBBB";

    private static final String DEFAULT_LASER = "AAAAAAAAAA";
    private static final String UPDATED_LASER = "BBBBBBBBBB";

    private static final Long DEFAULT_Q_TY_1 = 1L;
    private static final Long UPDATED_Q_TY_1 = 2L;

    private static final BigDecimal DEFAULT_U_SD = new BigDecimal(1);
    private static final BigDecimal UPDATED_U_SD = new BigDecimal(2);

    private static final String DEFAULT_COMPLETE_PRODUCTION = "AAAAAAAAAA";
    private static final String UPDATED_COMPLETE_PRODUCTION = "BBBBBBBBBB";

    private static final String DEFAULT_OUR_NOTETO_PRODUCTION = "AAAAAAAAAA";
    private static final String UPDATED_OUR_NOTETO_PRODUCTION = "BBBBBBBBBB";

    @Autowired
    private BrakeDiscRepository brakeDiscRepository;

    @Autowired
    private BrakeDiscMapper brakeDiscMapper;
    
    @Autowired
    private BrakeDiscService brakeDiscService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBrakeDiscMockMvc;

    private BrakeDisc brakeDisc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BrakeDiscResource brakeDiscResource = new BrakeDiscResource(brakeDiscService);
        this.restBrakeDiscMockMvc = MockMvcBuilders.standaloneSetup(brakeDiscResource)
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
    public static BrakeDisc createEntity(EntityManager em) {
        BrakeDisc brakeDisc = new BrakeDisc()
            .sku(DEFAULT_SKU)
            .active(DEFAULT_ACTIVE)
            .au(DEFAULT_AU)
            .de(DEFAULT_DE)
            .metalGearvisibility(DEFAULT_METAL_GEARVISIBILITY)
            .bikematevisibility(DEFAULT_BIKEMATEVISIBILITY)
            .mgiVisibility(DEFAULT_MGI_VISIBILITY)
            .discStatus(DEFAULT_DISC_STATUS)
            .productGroup1(DEFAULT_PRODUCT_GROUP_1)
            .productGroup2(DEFAULT_PRODUCT_GROUP_2)
            .fitment(DEFAULT_FITMENT)
            .description(DEFAULT_DESCRIPTION)
            .unit(DEFAULT_UNIT)
            .qty(DEFAULT_QTY)
            .brand(DEFAULT_BRAND)
            .biketypes(DEFAULT_BIKETYPES)
            .models2012on(DEFAULT_MODELS_2012_ON)
            .gS1EANNo(DEFAULT_G_S_1_EAN_NO)
            .ourNotes(DEFAULT_OUR_NOTES)
            .weight(DEFAULT_WEIGHT)
            .packType(DEFAULT_PACK_TYPE)
            .packLength(DEFAULT_PACK_LENGTH)
            .packHeight(DEFAULT_PACK_HEIGHT)
            .packWidth(DEFAULT_PACK_WIDTH)
            .packCubic(DEFAULT_PACK_CUBIC)
            .oD(DEFAULT_O_D)
            .bHC(DEFAULT_B_HC)
            .bHQty(DEFAULT_B_H_QTY)
            .bHSize(DEFAULT_B_H_SIZE)
            .bHOD(DEFAULT_B_HOD)
            .bHStep(DEFAULT_B_H_STEP)
            .bHType(DEFAULT_B_H_TYPE)
            .thickness(DEFAULT_THICKNESS)
            .thicknessMin(DEFAULT_THICKNESS_MIN)
            .offset(DEFAULT_OFFSET)
            .brakeAreawidth(DEFAULT_BRAKE_AREAWIDTH)
            .tUVLHC(DEFAULT_T_UVLHC)
            .customerNotes(DEFAULT_CUSTOMER_NOTES)
            .eListing(DEFAULT_E_LISTING)
            .eforMake(DEFAULT_EFOR_MAKE)
            .eDate(DEFAULT_E_DATE)
            .euploadedNeto(DEFAULT_EUPLOADED_NETO)
            .echeck(DEFAULT_ECHECK)
            .euploadedeBay(DEFAULT_EUPLOADEDE_BAY)
            .ebayactive(DEFAULT_EBAYACTIVE)
            .ePhotobucket(DEFAULT_E_PHOTOBUCKET)
            .ePhoto1(DEFAULT_E_PHOTO_1)
            .ePhoto2(DEFAULT_E_PHOTO_2)
            .ePhoto3(DEFAULT_E_PHOTO_3)
            .saleStatus(DEFAULT_SALE_STATUS)
            .rRP(DEFAULT_R_RP)
            .trade1(DEFAULT_TRADE_1)
            .eBAY(DEFAULT_E_BAY)
            .trade2(DEFAULT_TRADE_2)
            .trade3(DEFAULT_TRADE_3)
            .distributorNZAUD(DEFAULT_DISTRIBUTOR_NZAUD)
            .distributorEUR(DEFAULT_DISTRIBUTOR_EUR)
            .distributorUSD(DEFAULT_DISTRIBUTOR_USD)
            .sPriority(DEFAULT_S_PRIORITY)
            .samplefrom(DEFAULT_SAMPLEFROM)
            .requestedfrom(DEFAULT_REQUESTEDFROM)
            .date(DEFAULT_DATE)
            .received(DEFAULT_RECEIVED)
            .camefrom(DEFAULT_CAMEFROM)
            .paidfor(DEFAULT_PAIDFOR)
            .sentto(DEFAULT_SENTTO)
            .shipNo(DEFAULT_SHIP_NO)
            .datesent(DEFAULT_DATESENT)
            .samplereturn(DEFAULT_SAMPLERETURN)
            .make(DEFAULT_MAKE)
            .model(DEFAULT_MODEL)
            .year(DEFAULT_YEAR)
            .sampleFitment(DEFAULT_SAMPLE_FITMENT)
            .oEM(DEFAULT_O_EM)
            .notesforProduction(DEFAULT_NOTESFOR_PRODUCTION)
            .productionCode(DEFAULT_PRODUCTION_CODE)
            .hAPapproved(DEFAULT_H_A_PAPPROVED)
            .sHAapproved(DEFAULT_S_H_AAPPROVED)
            .approvedby(DEFAULT_APPROVEDBY)
            .notestoDrawing(DEFAULT_NOTESTO_DRAWING)
            .filename(DEFAULT_FILENAME)
            .cOSTUSD(DEFAULT_C_OSTUSD)
            .centrecolour(DEFAULT_CENTRECOLOUR)
            .laser(DEFAULT_LASER)
            .qTY1(DEFAULT_Q_TY_1)
            .uSD(DEFAULT_U_SD)
            .completeProduction(DEFAULT_COMPLETE_PRODUCTION)
            .ourNotetoProduction(DEFAULT_OUR_NOTETO_PRODUCTION);
        return brakeDisc;
    }

    @Before
    public void initTest() {
        brakeDisc = createEntity(em);
    }

    @Test
    @Transactional
    public void createBrakeDisc() throws Exception {
        int databaseSizeBeforeCreate = brakeDiscRepository.findAll().size();

        // Create the BrakeDisc
        BrakeDiscDTO brakeDiscDTO = brakeDiscMapper.toDto(brakeDisc);
        restBrakeDiscMockMvc.perform(post("/api/brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakeDiscDTO)))
            .andExpect(status().isCreated());

        // Validate the BrakeDisc in the database
        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeCreate + 1);
        BrakeDisc testBrakeDisc = brakeDiscList.get(brakeDiscList.size() - 1);
        assertThat(testBrakeDisc.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(testBrakeDisc.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testBrakeDisc.getAu()).isEqualTo(DEFAULT_AU);
        assertThat(testBrakeDisc.getDe()).isEqualTo(DEFAULT_DE);
        assertThat(testBrakeDisc.getMetalGearvisibility()).isEqualTo(DEFAULT_METAL_GEARVISIBILITY);
        assertThat(testBrakeDisc.getBikematevisibility()).isEqualTo(DEFAULT_BIKEMATEVISIBILITY);
        assertThat(testBrakeDisc.getMgiVisibility()).isEqualTo(DEFAULT_MGI_VISIBILITY);
        assertThat(testBrakeDisc.getDiscStatus()).isEqualTo(DEFAULT_DISC_STATUS);
        assertThat(testBrakeDisc.getProductGroup1()).isEqualTo(DEFAULT_PRODUCT_GROUP_1);
        assertThat(testBrakeDisc.getProductGroup2()).isEqualTo(DEFAULT_PRODUCT_GROUP_2);
        assertThat(testBrakeDisc.getFitment()).isEqualTo(DEFAULT_FITMENT);
        assertThat(testBrakeDisc.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testBrakeDisc.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testBrakeDisc.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testBrakeDisc.getBrand()).isEqualTo(DEFAULT_BRAND);
        assertThat(testBrakeDisc.getBiketypes()).isEqualTo(DEFAULT_BIKETYPES);
        assertThat(testBrakeDisc.getModels2012on()).isEqualTo(DEFAULT_MODELS_2012_ON);
        assertThat(testBrakeDisc.getgS1EANNo()).isEqualTo(DEFAULT_G_S_1_EAN_NO);
        assertThat(testBrakeDisc.getOurNotes()).isEqualTo(DEFAULT_OUR_NOTES);
        assertThat(testBrakeDisc.getWeight()).isEqualTo(DEFAULT_WEIGHT);
        assertThat(testBrakeDisc.getPackType()).isEqualTo(DEFAULT_PACK_TYPE);
        assertThat(testBrakeDisc.getPackLength()).isEqualTo(DEFAULT_PACK_LENGTH);
        assertThat(testBrakeDisc.getPackHeight()).isEqualTo(DEFAULT_PACK_HEIGHT);
        assertThat(testBrakeDisc.getPackWidth()).isEqualTo(DEFAULT_PACK_WIDTH);
        assertThat(testBrakeDisc.getPackCubic()).isEqualTo(DEFAULT_PACK_CUBIC);
        assertThat(testBrakeDisc.getoD()).isEqualTo(DEFAULT_O_D);
        assertThat(testBrakeDisc.getbHC()).isEqualTo(DEFAULT_B_HC);
        assertThat(testBrakeDisc.getbHQty()).isEqualTo(DEFAULT_B_H_QTY);
        assertThat(testBrakeDisc.getbHSize()).isEqualTo(DEFAULT_B_H_SIZE);
        assertThat(testBrakeDisc.getbHOD()).isEqualTo(DEFAULT_B_HOD);
        assertThat(testBrakeDisc.getbHStep()).isEqualTo(DEFAULT_B_H_STEP);
        assertThat(testBrakeDisc.getbHType()).isEqualTo(DEFAULT_B_H_TYPE);
        assertThat(testBrakeDisc.getThickness()).isEqualTo(DEFAULT_THICKNESS);
        assertThat(testBrakeDisc.getThicknessMin()).isEqualTo(DEFAULT_THICKNESS_MIN);
        assertThat(testBrakeDisc.getOffset()).isEqualTo(DEFAULT_OFFSET);
        assertThat(testBrakeDisc.getBrakeAreawidth()).isEqualTo(DEFAULT_BRAKE_AREAWIDTH);
        assertThat(testBrakeDisc.gettUVLHC()).isEqualTo(DEFAULT_T_UVLHC);
        assertThat(testBrakeDisc.getCustomerNotes()).isEqualTo(DEFAULT_CUSTOMER_NOTES);
        assertThat(testBrakeDisc.geteListing()).isEqualTo(DEFAULT_E_LISTING);
        assertThat(testBrakeDisc.getEforMake()).isEqualTo(DEFAULT_EFOR_MAKE);
        assertThat(testBrakeDisc.geteDate()).isEqualTo(DEFAULT_E_DATE);
        assertThat(testBrakeDisc.getEuploadedNeto()).isEqualTo(DEFAULT_EUPLOADED_NETO);
        assertThat(testBrakeDisc.getEcheck()).isEqualTo(DEFAULT_ECHECK);
        assertThat(testBrakeDisc.getEuploadedeBay()).isEqualTo(DEFAULT_EUPLOADEDE_BAY);
        assertThat(testBrakeDisc.getEbayactive()).isEqualTo(DEFAULT_EBAYACTIVE);
        assertThat(testBrakeDisc.getePhotobucket()).isEqualTo(DEFAULT_E_PHOTOBUCKET);
        assertThat(testBrakeDisc.getePhoto1()).isEqualTo(DEFAULT_E_PHOTO_1);
        assertThat(testBrakeDisc.getePhoto2()).isEqualTo(DEFAULT_E_PHOTO_2);
        assertThat(testBrakeDisc.getePhoto3()).isEqualTo(DEFAULT_E_PHOTO_3);
        assertThat(testBrakeDisc.getSaleStatus()).isEqualTo(DEFAULT_SALE_STATUS);
        assertThat(testBrakeDisc.getrRP()).isEqualTo(DEFAULT_R_RP);
        assertThat(testBrakeDisc.getTrade1()).isEqualTo(DEFAULT_TRADE_1);
        assertThat(testBrakeDisc.geteBAY()).isEqualTo(DEFAULT_E_BAY);
        assertThat(testBrakeDisc.getTrade2()).isEqualTo(DEFAULT_TRADE_2);
        assertThat(testBrakeDisc.getTrade3()).isEqualTo(DEFAULT_TRADE_3);
        assertThat(testBrakeDisc.getDistributorNZAUD()).isEqualTo(DEFAULT_DISTRIBUTOR_NZAUD);
        assertThat(testBrakeDisc.getDistributorEUR()).isEqualTo(DEFAULT_DISTRIBUTOR_EUR);
        assertThat(testBrakeDisc.getDistributorUSD()).isEqualTo(DEFAULT_DISTRIBUTOR_USD);
        assertThat(testBrakeDisc.getsPriority()).isEqualTo(DEFAULT_S_PRIORITY);
        assertThat(testBrakeDisc.getSamplefrom()).isEqualTo(DEFAULT_SAMPLEFROM);
        assertThat(testBrakeDisc.getRequestedfrom()).isEqualTo(DEFAULT_REQUESTEDFROM);
        assertThat(testBrakeDisc.getDate()).isEqualTo(DEFAULT_DATE);
        assertThat(testBrakeDisc.getReceived()).isEqualTo(DEFAULT_RECEIVED);
        assertThat(testBrakeDisc.getCamefrom()).isEqualTo(DEFAULT_CAMEFROM);
        assertThat(testBrakeDisc.getPaidfor()).isEqualTo(DEFAULT_PAIDFOR);
        assertThat(testBrakeDisc.getSentto()).isEqualTo(DEFAULT_SENTTO);
        assertThat(testBrakeDisc.getShipNo()).isEqualTo(DEFAULT_SHIP_NO);
        assertThat(testBrakeDisc.getDatesent()).isEqualTo(DEFAULT_DATESENT);
        assertThat(testBrakeDisc.getSamplereturn()).isEqualTo(DEFAULT_SAMPLERETURN);
        assertThat(testBrakeDisc.getMake()).isEqualTo(DEFAULT_MAKE);
        assertThat(testBrakeDisc.getModel()).isEqualTo(DEFAULT_MODEL);
        assertThat(testBrakeDisc.getYear()).isEqualTo(DEFAULT_YEAR);
        assertThat(testBrakeDisc.getSampleFitment()).isEqualTo(DEFAULT_SAMPLE_FITMENT);
        assertThat(testBrakeDisc.getoEM()).isEqualTo(DEFAULT_O_EM);
        assertThat(testBrakeDisc.getNotesforProduction()).isEqualTo(DEFAULT_NOTESFOR_PRODUCTION);
        assertThat(testBrakeDisc.getProductionCode()).isEqualTo(DEFAULT_PRODUCTION_CODE);
        assertThat(testBrakeDisc.gethAPapproved()).isEqualTo(DEFAULT_H_A_PAPPROVED);
        assertThat(testBrakeDisc.getsHAapproved()).isEqualTo(DEFAULT_S_H_AAPPROVED);
        assertThat(testBrakeDisc.getApprovedby()).isEqualTo(DEFAULT_APPROVEDBY);
        assertThat(testBrakeDisc.getNotestoDrawing()).isEqualTo(DEFAULT_NOTESTO_DRAWING);
        assertThat(testBrakeDisc.getFilename()).isEqualTo(DEFAULT_FILENAME);
        assertThat(testBrakeDisc.getcOSTUSD()).isEqualTo(DEFAULT_C_OSTUSD);
        assertThat(testBrakeDisc.getCentrecolour()).isEqualTo(DEFAULT_CENTRECOLOUR);
        assertThat(testBrakeDisc.getLaser()).isEqualTo(DEFAULT_LASER);
        assertThat(testBrakeDisc.getqTY1()).isEqualTo(DEFAULT_Q_TY_1);
        assertThat(testBrakeDisc.getuSD()).isEqualTo(DEFAULT_U_SD);
        assertThat(testBrakeDisc.getCompleteProduction()).isEqualTo(DEFAULT_COMPLETE_PRODUCTION);
        assertThat(testBrakeDisc.getOurNotetoProduction()).isEqualTo(DEFAULT_OUR_NOTETO_PRODUCTION);
    }

    @Test
    @Transactional
    public void createBrakeDiscWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = brakeDiscRepository.findAll().size();

        // Create the BrakeDisc with an existing ID
        brakeDisc.setId(1L);
        BrakeDiscDTO brakeDiscDTO = brakeDiscMapper.toDto(brakeDisc);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBrakeDiscMockMvc.perform(post("/api/brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakeDiscDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BrakeDisc in the database
        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSkuIsRequired() throws Exception {
        int databaseSizeBeforeTest = brakeDiscRepository.findAll().size();
        // set the field null
        brakeDisc.setSku(null);

        // Create the BrakeDisc, which fails.
        BrakeDiscDTO brakeDiscDTO = brakeDiscMapper.toDto(brakeDisc);

        restBrakeDiscMockMvc.perform(post("/api/brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakeDiscDTO)))
            .andExpect(status().isBadRequest());

        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBrakeDiscs() throws Exception {
        // Initialize the database
        brakeDiscRepository.saveAndFlush(brakeDisc);

        // Get all the brakeDiscList
        restBrakeDiscMockMvc.perform(get("/api/brake-discs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(brakeDisc.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE.toString())))
            .andExpect(jsonPath("$.[*].au").value(hasItem(DEFAULT_AU.toString())))
            .andExpect(jsonPath("$.[*].de").value(hasItem(DEFAULT_DE.toString())))
            .andExpect(jsonPath("$.[*].metalGearvisibility").value(hasItem(DEFAULT_METAL_GEARVISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].bikematevisibility").value(hasItem(DEFAULT_BIKEMATEVISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].mgiVisibility").value(hasItem(DEFAULT_MGI_VISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].discStatus").value(hasItem(DEFAULT_DISC_STATUS.toString())))
            .andExpect(jsonPath("$.[*].productGroup1").value(hasItem(DEFAULT_PRODUCT_GROUP_1.toString())))
            .andExpect(jsonPath("$.[*].productGroup2").value(hasItem(DEFAULT_PRODUCT_GROUP_2.toString())))
            .andExpect(jsonPath("$.[*].fitment").value(hasItem(DEFAULT_FITMENT.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.toString())))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY.intValue())))
            .andExpect(jsonPath("$.[*].brand").value(hasItem(DEFAULT_BRAND.toString())))
            .andExpect(jsonPath("$.[*].biketypes").value(hasItem(DEFAULT_BIKETYPES.toString())))
            .andExpect(jsonPath("$.[*].models2012on").value(hasItem(DEFAULT_MODELS_2012_ON.toString())))
            .andExpect(jsonPath("$.[*].gS1EANNo").value(hasItem(DEFAULT_G_S_1_EAN_NO.intValue())))
            .andExpect(jsonPath("$.[*].ourNotes").value(hasItem(DEFAULT_OUR_NOTES.toString())))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].packType").value(hasItem(DEFAULT_PACK_TYPE.toString())))
            .andExpect(jsonPath("$.[*].packLength").value(hasItem(DEFAULT_PACK_LENGTH.intValue())))
            .andExpect(jsonPath("$.[*].packHeight").value(hasItem(DEFAULT_PACK_HEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].packWidth").value(hasItem(DEFAULT_PACK_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].packCubic").value(hasItem(DEFAULT_PACK_CUBIC.intValue())))
            .andExpect(jsonPath("$.[*].oD").value(hasItem(DEFAULT_O_D.intValue())))
            .andExpect(jsonPath("$.[*].bHC").value(hasItem(DEFAULT_B_HC.toString())))
            .andExpect(jsonPath("$.[*].bHQty").value(hasItem(DEFAULT_B_H_QTY.intValue())))
            .andExpect(jsonPath("$.[*].bHSize").value(hasItem(DEFAULT_B_H_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].bHOD").value(hasItem(DEFAULT_B_HOD.intValue())))
            .andExpect(jsonPath("$.[*].bHStep").value(hasItem(DEFAULT_B_H_STEP.intValue())))
            .andExpect(jsonPath("$.[*].bHType").value(hasItem(DEFAULT_B_H_TYPE.toString())))
            .andExpect(jsonPath("$.[*].thickness").value(hasItem(DEFAULT_THICKNESS.intValue())))
            .andExpect(jsonPath("$.[*].thicknessMin").value(hasItem(DEFAULT_THICKNESS_MIN.intValue())))
            .andExpect(jsonPath("$.[*].offset").value(hasItem(DEFAULT_OFFSET.intValue())))
            .andExpect(jsonPath("$.[*].brakeAreawidth").value(hasItem(DEFAULT_BRAKE_AREAWIDTH.intValue())))
            .andExpect(jsonPath("$.[*].tUVLHC").value(hasItem(DEFAULT_T_UVLHC.toString())))
            .andExpect(jsonPath("$.[*].customerNotes").value(hasItem(DEFAULT_CUSTOMER_NOTES.toString())))
            .andExpect(jsonPath("$.[*].eListing").value(hasItem(DEFAULT_E_LISTING.toString())))
            .andExpect(jsonPath("$.[*].eforMake").value(hasItem(DEFAULT_EFOR_MAKE.toString())))
            .andExpect(jsonPath("$.[*].eDate").value(hasItem(DEFAULT_E_DATE.toString())))
            .andExpect(jsonPath("$.[*].euploadedNeto").value(hasItem(DEFAULT_EUPLOADED_NETO.toString())))
            .andExpect(jsonPath("$.[*].echeck").value(hasItem(DEFAULT_ECHECK.toString())))
            .andExpect(jsonPath("$.[*].euploadedeBay").value(hasItem(DEFAULT_EUPLOADEDE_BAY.toString())))
            .andExpect(jsonPath("$.[*].ebayactive").value(hasItem(DEFAULT_EBAYACTIVE.toString())))
            .andExpect(jsonPath("$.[*].ePhotobucket").value(hasItem(DEFAULT_E_PHOTOBUCKET.toString())))
            .andExpect(jsonPath("$.[*].ePhoto1").value(hasItem(DEFAULT_E_PHOTO_1.toString())))
            .andExpect(jsonPath("$.[*].ePhoto2").value(hasItem(DEFAULT_E_PHOTO_2.toString())))
            .andExpect(jsonPath("$.[*].ePhoto3").value(hasItem(DEFAULT_E_PHOTO_3.toString())))
            .andExpect(jsonPath("$.[*].saleStatus").value(hasItem(DEFAULT_SALE_STATUS.toString())))
            .andExpect(jsonPath("$.[*].rRP").value(hasItem(DEFAULT_R_RP.intValue())))
            .andExpect(jsonPath("$.[*].trade1").value(hasItem(DEFAULT_TRADE_1.intValue())))
            .andExpect(jsonPath("$.[*].eBAY").value(hasItem(DEFAULT_E_BAY.intValue())))
            .andExpect(jsonPath("$.[*].trade2").value(hasItem(DEFAULT_TRADE_2.intValue())))
            .andExpect(jsonPath("$.[*].trade3").value(hasItem(DEFAULT_TRADE_3.intValue())))
            .andExpect(jsonPath("$.[*].distributorNZAUD").value(hasItem(DEFAULT_DISTRIBUTOR_NZAUD.intValue())))
            .andExpect(jsonPath("$.[*].distributorEUR").value(hasItem(DEFAULT_DISTRIBUTOR_EUR.intValue())))
            .andExpect(jsonPath("$.[*].distributorUSD").value(hasItem(DEFAULT_DISTRIBUTOR_USD.intValue())))
            .andExpect(jsonPath("$.[*].sPriority").value(hasItem(DEFAULT_S_PRIORITY.toString())))
            .andExpect(jsonPath("$.[*].samplefrom").value(hasItem(DEFAULT_SAMPLEFROM.toString())))
            .andExpect(jsonPath("$.[*].requestedfrom").value(hasItem(DEFAULT_REQUESTEDFROM.toString())))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())))
            .andExpect(jsonPath("$.[*].received").value(hasItem(DEFAULT_RECEIVED.toString())))
            .andExpect(jsonPath("$.[*].camefrom").value(hasItem(DEFAULT_CAMEFROM.toString())))
            .andExpect(jsonPath("$.[*].paidfor").value(hasItem(DEFAULT_PAIDFOR.toString())))
            .andExpect(jsonPath("$.[*].sentto").value(hasItem(DEFAULT_SENTTO.toString())))
            .andExpect(jsonPath("$.[*].shipNo").value(hasItem(DEFAULT_SHIP_NO.intValue())))
            .andExpect(jsonPath("$.[*].datesent").value(hasItem(DEFAULT_DATESENT.toString())))
            .andExpect(jsonPath("$.[*].samplereturn").value(hasItem(DEFAULT_SAMPLERETURN.toString())))
            .andExpect(jsonPath("$.[*].make").value(hasItem(DEFAULT_MAKE.toString())))
            .andExpect(jsonPath("$.[*].model").value(hasItem(DEFAULT_MODEL.toString())))
            .andExpect(jsonPath("$.[*].year").value(hasItem(DEFAULT_YEAR.toString())))
            .andExpect(jsonPath("$.[*].sampleFitment").value(hasItem(DEFAULT_SAMPLE_FITMENT.toString())))
            .andExpect(jsonPath("$.[*].oEM").value(hasItem(DEFAULT_O_EM.toString())))
            .andExpect(jsonPath("$.[*].notesforProduction").value(hasItem(DEFAULT_NOTESFOR_PRODUCTION.toString())))
            .andExpect(jsonPath("$.[*].productionCode").value(hasItem(DEFAULT_PRODUCTION_CODE.toString())))
            .andExpect(jsonPath("$.[*].hAPapproved").value(hasItem(DEFAULT_H_A_PAPPROVED.toString())))
            .andExpect(jsonPath("$.[*].sHAapproved").value(hasItem(DEFAULT_S_H_AAPPROVED.toString())))
            .andExpect(jsonPath("$.[*].approvedby").value(hasItem(DEFAULT_APPROVEDBY.toString())))
            .andExpect(jsonPath("$.[*].notestoDrawing").value(hasItem(DEFAULT_NOTESTO_DRAWING.toString())))
            .andExpect(jsonPath("$.[*].filename").value(hasItem(DEFAULT_FILENAME.toString())))
            .andExpect(jsonPath("$.[*].cOSTUSD").value(hasItem(DEFAULT_C_OSTUSD.intValue())))
            .andExpect(jsonPath("$.[*].centrecolour").value(hasItem(DEFAULT_CENTRECOLOUR.toString())))
            .andExpect(jsonPath("$.[*].laser").value(hasItem(DEFAULT_LASER.toString())))
            .andExpect(jsonPath("$.[*].qTY1").value(hasItem(DEFAULT_Q_TY_1.intValue())))
            .andExpect(jsonPath("$.[*].uSD").value(hasItem(DEFAULT_U_SD.intValue())))
            .andExpect(jsonPath("$.[*].completeProduction").value(hasItem(DEFAULT_COMPLETE_PRODUCTION.toString())))
            .andExpect(jsonPath("$.[*].ourNotetoProduction").value(hasItem(DEFAULT_OUR_NOTETO_PRODUCTION.toString())));
    }
    
    @Test
    @Transactional
    public void getBrakeDisc() throws Exception {
        // Initialize the database
        brakeDiscRepository.saveAndFlush(brakeDisc);

        // Get the brakeDisc
        restBrakeDiscMockMvc.perform(get("/api/brake-discs/{id}", brakeDisc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(brakeDisc.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()))
            .andExpect(jsonPath("$.active").value(DEFAULT_ACTIVE.toString()))
            .andExpect(jsonPath("$.au").value(DEFAULT_AU.toString()))
            .andExpect(jsonPath("$.de").value(DEFAULT_DE.toString()))
            .andExpect(jsonPath("$.metalGearvisibility").value(DEFAULT_METAL_GEARVISIBILITY.toString()))
            .andExpect(jsonPath("$.bikematevisibility").value(DEFAULT_BIKEMATEVISIBILITY.toString()))
            .andExpect(jsonPath("$.mgiVisibility").value(DEFAULT_MGI_VISIBILITY.toString()))
            .andExpect(jsonPath("$.discStatus").value(DEFAULT_DISC_STATUS.toString()))
            .andExpect(jsonPath("$.productGroup1").value(DEFAULT_PRODUCT_GROUP_1.toString()))
            .andExpect(jsonPath("$.productGroup2").value(DEFAULT_PRODUCT_GROUP_2.toString()))
            .andExpect(jsonPath("$.fitment").value(DEFAULT_FITMENT.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.toString()))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY.intValue()))
            .andExpect(jsonPath("$.brand").value(DEFAULT_BRAND.toString()))
            .andExpect(jsonPath("$.biketypes").value(DEFAULT_BIKETYPES.toString()))
            .andExpect(jsonPath("$.models2012on").value(DEFAULT_MODELS_2012_ON.toString()))
            .andExpect(jsonPath("$.gS1EANNo").value(DEFAULT_G_S_1_EAN_NO.intValue()))
            .andExpect(jsonPath("$.ourNotes").value(DEFAULT_OUR_NOTES.toString()))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT.intValue()))
            .andExpect(jsonPath("$.packType").value(DEFAULT_PACK_TYPE.toString()))
            .andExpect(jsonPath("$.packLength").value(DEFAULT_PACK_LENGTH.intValue()))
            .andExpect(jsonPath("$.packHeight").value(DEFAULT_PACK_HEIGHT.intValue()))
            .andExpect(jsonPath("$.packWidth").value(DEFAULT_PACK_WIDTH.intValue()))
            .andExpect(jsonPath("$.packCubic").value(DEFAULT_PACK_CUBIC.intValue()))
            .andExpect(jsonPath("$.oD").value(DEFAULT_O_D.intValue()))
            .andExpect(jsonPath("$.bHC").value(DEFAULT_B_HC.toString()))
            .andExpect(jsonPath("$.bHQty").value(DEFAULT_B_H_QTY.intValue()))
            .andExpect(jsonPath("$.bHSize").value(DEFAULT_B_H_SIZE.intValue()))
            .andExpect(jsonPath("$.bHOD").value(DEFAULT_B_HOD.intValue()))
            .andExpect(jsonPath("$.bHStep").value(DEFAULT_B_H_STEP.intValue()))
            .andExpect(jsonPath("$.bHType").value(DEFAULT_B_H_TYPE.toString()))
            .andExpect(jsonPath("$.thickness").value(DEFAULT_THICKNESS.intValue()))
            .andExpect(jsonPath("$.thicknessMin").value(DEFAULT_THICKNESS_MIN.intValue()))
            .andExpect(jsonPath("$.offset").value(DEFAULT_OFFSET.intValue()))
            .andExpect(jsonPath("$.brakeAreawidth").value(DEFAULT_BRAKE_AREAWIDTH.intValue()))
            .andExpect(jsonPath("$.tUVLHC").value(DEFAULT_T_UVLHC.toString()))
            .andExpect(jsonPath("$.customerNotes").value(DEFAULT_CUSTOMER_NOTES.toString()))
            .andExpect(jsonPath("$.eListing").value(DEFAULT_E_LISTING.toString()))
            .andExpect(jsonPath("$.eforMake").value(DEFAULT_EFOR_MAKE.toString()))
            .andExpect(jsonPath("$.eDate").value(DEFAULT_E_DATE.toString()))
            .andExpect(jsonPath("$.euploadedNeto").value(DEFAULT_EUPLOADED_NETO.toString()))
            .andExpect(jsonPath("$.echeck").value(DEFAULT_ECHECK.toString()))
            .andExpect(jsonPath("$.euploadedeBay").value(DEFAULT_EUPLOADEDE_BAY.toString()))
            .andExpect(jsonPath("$.ebayactive").value(DEFAULT_EBAYACTIVE.toString()))
            .andExpect(jsonPath("$.ePhotobucket").value(DEFAULT_E_PHOTOBUCKET.toString()))
            .andExpect(jsonPath("$.ePhoto1").value(DEFAULT_E_PHOTO_1.toString()))
            .andExpect(jsonPath("$.ePhoto2").value(DEFAULT_E_PHOTO_2.toString()))
            .andExpect(jsonPath("$.ePhoto3").value(DEFAULT_E_PHOTO_3.toString()))
            .andExpect(jsonPath("$.saleStatus").value(DEFAULT_SALE_STATUS.toString()))
            .andExpect(jsonPath("$.rRP").value(DEFAULT_R_RP.intValue()))
            .andExpect(jsonPath("$.trade1").value(DEFAULT_TRADE_1.intValue()))
            .andExpect(jsonPath("$.eBAY").value(DEFAULT_E_BAY.intValue()))
            .andExpect(jsonPath("$.trade2").value(DEFAULT_TRADE_2.intValue()))
            .andExpect(jsonPath("$.trade3").value(DEFAULT_TRADE_3.intValue()))
            .andExpect(jsonPath("$.distributorNZAUD").value(DEFAULT_DISTRIBUTOR_NZAUD.intValue()))
            .andExpect(jsonPath("$.distributorEUR").value(DEFAULT_DISTRIBUTOR_EUR.intValue()))
            .andExpect(jsonPath("$.distributorUSD").value(DEFAULT_DISTRIBUTOR_USD.intValue()))
            .andExpect(jsonPath("$.sPriority").value(DEFAULT_S_PRIORITY.toString()))
            .andExpect(jsonPath("$.samplefrom").value(DEFAULT_SAMPLEFROM.toString()))
            .andExpect(jsonPath("$.requestedfrom").value(DEFAULT_REQUESTEDFROM.toString()))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()))
            .andExpect(jsonPath("$.received").value(DEFAULT_RECEIVED.toString()))
            .andExpect(jsonPath("$.camefrom").value(DEFAULT_CAMEFROM.toString()))
            .andExpect(jsonPath("$.paidfor").value(DEFAULT_PAIDFOR.toString()))
            .andExpect(jsonPath("$.sentto").value(DEFAULT_SENTTO.toString()))
            .andExpect(jsonPath("$.shipNo").value(DEFAULT_SHIP_NO.intValue()))
            .andExpect(jsonPath("$.datesent").value(DEFAULT_DATESENT.toString()))
            .andExpect(jsonPath("$.samplereturn").value(DEFAULT_SAMPLERETURN.toString()))
            .andExpect(jsonPath("$.make").value(DEFAULT_MAKE.toString()))
            .andExpect(jsonPath("$.model").value(DEFAULT_MODEL.toString()))
            .andExpect(jsonPath("$.year").value(DEFAULT_YEAR.toString()))
            .andExpect(jsonPath("$.sampleFitment").value(DEFAULT_SAMPLE_FITMENT.toString()))
            .andExpect(jsonPath("$.oEM").value(DEFAULT_O_EM.toString()))
            .andExpect(jsonPath("$.notesforProduction").value(DEFAULT_NOTESFOR_PRODUCTION.toString()))
            .andExpect(jsonPath("$.productionCode").value(DEFAULT_PRODUCTION_CODE.toString()))
            .andExpect(jsonPath("$.hAPapproved").value(DEFAULT_H_A_PAPPROVED.toString()))
            .andExpect(jsonPath("$.sHAapproved").value(DEFAULT_S_H_AAPPROVED.toString()))
            .andExpect(jsonPath("$.approvedby").value(DEFAULT_APPROVEDBY.toString()))
            .andExpect(jsonPath("$.notestoDrawing").value(DEFAULT_NOTESTO_DRAWING.toString()))
            .andExpect(jsonPath("$.filename").value(DEFAULT_FILENAME.toString()))
            .andExpect(jsonPath("$.cOSTUSD").value(DEFAULT_C_OSTUSD.intValue()))
            .andExpect(jsonPath("$.centrecolour").value(DEFAULT_CENTRECOLOUR.toString()))
            .andExpect(jsonPath("$.laser").value(DEFAULT_LASER.toString()))
            .andExpect(jsonPath("$.qTY1").value(DEFAULT_Q_TY_1.intValue()))
            .andExpect(jsonPath("$.uSD").value(DEFAULT_U_SD.intValue()))
            .andExpect(jsonPath("$.completeProduction").value(DEFAULT_COMPLETE_PRODUCTION.toString()))
            .andExpect(jsonPath("$.ourNotetoProduction").value(DEFAULT_OUR_NOTETO_PRODUCTION.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBrakeDisc() throws Exception {
        // Get the brakeDisc
        restBrakeDiscMockMvc.perform(get("/api/brake-discs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBrakeDisc() throws Exception {
        // Initialize the database
        brakeDiscRepository.saveAndFlush(brakeDisc);

        int databaseSizeBeforeUpdate = brakeDiscRepository.findAll().size();

        // Update the brakeDisc
        BrakeDisc updatedBrakeDisc = brakeDiscRepository.findById(brakeDisc.getId()).get();
        // Disconnect from session so that the updates on updatedBrakeDisc are not directly saved in db
        em.detach(updatedBrakeDisc);
        updatedBrakeDisc
            .sku(UPDATED_SKU)
            .active(UPDATED_ACTIVE)
            .au(UPDATED_AU)
            .de(UPDATED_DE)
            .metalGearvisibility(UPDATED_METAL_GEARVISIBILITY)
            .bikematevisibility(UPDATED_BIKEMATEVISIBILITY)
            .mgiVisibility(UPDATED_MGI_VISIBILITY)
            .discStatus(UPDATED_DISC_STATUS)
            .productGroup1(UPDATED_PRODUCT_GROUP_1)
            .productGroup2(UPDATED_PRODUCT_GROUP_2)
            .fitment(UPDATED_FITMENT)
            .description(UPDATED_DESCRIPTION)
            .unit(UPDATED_UNIT)
            .qty(UPDATED_QTY)
            .brand(UPDATED_BRAND)
            .biketypes(UPDATED_BIKETYPES)
            .models2012on(UPDATED_MODELS_2012_ON)
            .gS1EANNo(UPDATED_G_S_1_EAN_NO)
            .ourNotes(UPDATED_OUR_NOTES)
            .weight(UPDATED_WEIGHT)
            .packType(UPDATED_PACK_TYPE)
            .packLength(UPDATED_PACK_LENGTH)
            .packHeight(UPDATED_PACK_HEIGHT)
            .packWidth(UPDATED_PACK_WIDTH)
            .packCubic(UPDATED_PACK_CUBIC)
            .oD(UPDATED_O_D)
            .bHC(UPDATED_B_HC)
            .bHQty(UPDATED_B_H_QTY)
            .bHSize(UPDATED_B_H_SIZE)
            .bHOD(UPDATED_B_HOD)
            .bHStep(UPDATED_B_H_STEP)
            .bHType(UPDATED_B_H_TYPE)
            .thickness(UPDATED_THICKNESS)
            .thicknessMin(UPDATED_THICKNESS_MIN)
            .offset(UPDATED_OFFSET)
            .brakeAreawidth(UPDATED_BRAKE_AREAWIDTH)
            .tUVLHC(UPDATED_T_UVLHC)
            .customerNotes(UPDATED_CUSTOMER_NOTES)
            .eListing(UPDATED_E_LISTING)
            .eforMake(UPDATED_EFOR_MAKE)
            .eDate(UPDATED_E_DATE)
            .euploadedNeto(UPDATED_EUPLOADED_NETO)
            .echeck(UPDATED_ECHECK)
            .euploadedeBay(UPDATED_EUPLOADEDE_BAY)
            .ebayactive(UPDATED_EBAYACTIVE)
            .ePhotobucket(UPDATED_E_PHOTOBUCKET)
            .ePhoto1(UPDATED_E_PHOTO_1)
            .ePhoto2(UPDATED_E_PHOTO_2)
            .ePhoto3(UPDATED_E_PHOTO_3)
            .saleStatus(UPDATED_SALE_STATUS)
            .rRP(UPDATED_R_RP)
            .trade1(UPDATED_TRADE_1)
            .eBAY(UPDATED_E_BAY)
            .trade2(UPDATED_TRADE_2)
            .trade3(UPDATED_TRADE_3)
            .distributorNZAUD(UPDATED_DISTRIBUTOR_NZAUD)
            .distributorEUR(UPDATED_DISTRIBUTOR_EUR)
            .distributorUSD(UPDATED_DISTRIBUTOR_USD)
            .sPriority(UPDATED_S_PRIORITY)
            .samplefrom(UPDATED_SAMPLEFROM)
            .requestedfrom(UPDATED_REQUESTEDFROM)
            .date(UPDATED_DATE)
            .received(UPDATED_RECEIVED)
            .camefrom(UPDATED_CAMEFROM)
            .paidfor(UPDATED_PAIDFOR)
            .sentto(UPDATED_SENTTO)
            .shipNo(UPDATED_SHIP_NO)
            .datesent(UPDATED_DATESENT)
            .samplereturn(UPDATED_SAMPLERETURN)
            .make(UPDATED_MAKE)
            .model(UPDATED_MODEL)
            .year(UPDATED_YEAR)
            .sampleFitment(UPDATED_SAMPLE_FITMENT)
            .oEM(UPDATED_O_EM)
            .notesforProduction(UPDATED_NOTESFOR_PRODUCTION)
            .productionCode(UPDATED_PRODUCTION_CODE)
            .hAPapproved(UPDATED_H_A_PAPPROVED)
            .sHAapproved(UPDATED_S_H_AAPPROVED)
            .approvedby(UPDATED_APPROVEDBY)
            .notestoDrawing(UPDATED_NOTESTO_DRAWING)
            .filename(UPDATED_FILENAME)
            .cOSTUSD(UPDATED_C_OSTUSD)
            .centrecolour(UPDATED_CENTRECOLOUR)
            .laser(UPDATED_LASER)
            .qTY1(UPDATED_Q_TY_1)
            .uSD(UPDATED_U_SD)
            .completeProduction(UPDATED_COMPLETE_PRODUCTION)
            .ourNotetoProduction(UPDATED_OUR_NOTETO_PRODUCTION);
        BrakeDiscDTO brakeDiscDTO = brakeDiscMapper.toDto(updatedBrakeDisc);

        restBrakeDiscMockMvc.perform(put("/api/brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakeDiscDTO)))
            .andExpect(status().isOk());

        // Validate the BrakeDisc in the database
        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeUpdate);
        BrakeDisc testBrakeDisc = brakeDiscList.get(brakeDiscList.size() - 1);
        assertThat(testBrakeDisc.getSku()).isEqualTo(UPDATED_SKU);
        assertThat(testBrakeDisc.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testBrakeDisc.getAu()).isEqualTo(UPDATED_AU);
        assertThat(testBrakeDisc.getDe()).isEqualTo(UPDATED_DE);
        assertThat(testBrakeDisc.getMetalGearvisibility()).isEqualTo(UPDATED_METAL_GEARVISIBILITY);
        assertThat(testBrakeDisc.getBikematevisibility()).isEqualTo(UPDATED_BIKEMATEVISIBILITY);
        assertThat(testBrakeDisc.getMgiVisibility()).isEqualTo(UPDATED_MGI_VISIBILITY);
        assertThat(testBrakeDisc.getDiscStatus()).isEqualTo(UPDATED_DISC_STATUS);
        assertThat(testBrakeDisc.getProductGroup1()).isEqualTo(UPDATED_PRODUCT_GROUP_1);
        assertThat(testBrakeDisc.getProductGroup2()).isEqualTo(UPDATED_PRODUCT_GROUP_2);
        assertThat(testBrakeDisc.getFitment()).isEqualTo(UPDATED_FITMENT);
        assertThat(testBrakeDisc.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testBrakeDisc.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testBrakeDisc.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testBrakeDisc.getBrand()).isEqualTo(UPDATED_BRAND);
        assertThat(testBrakeDisc.getBiketypes()).isEqualTo(UPDATED_BIKETYPES);
        assertThat(testBrakeDisc.getModels2012on()).isEqualTo(UPDATED_MODELS_2012_ON);
        assertThat(testBrakeDisc.getgS1EANNo()).isEqualTo(UPDATED_G_S_1_EAN_NO);
        assertThat(testBrakeDisc.getOurNotes()).isEqualTo(UPDATED_OUR_NOTES);
        assertThat(testBrakeDisc.getWeight()).isEqualTo(UPDATED_WEIGHT);
        assertThat(testBrakeDisc.getPackType()).isEqualTo(UPDATED_PACK_TYPE);
        assertThat(testBrakeDisc.getPackLength()).isEqualTo(UPDATED_PACK_LENGTH);
        assertThat(testBrakeDisc.getPackHeight()).isEqualTo(UPDATED_PACK_HEIGHT);
        assertThat(testBrakeDisc.getPackWidth()).isEqualTo(UPDATED_PACK_WIDTH);
        assertThat(testBrakeDisc.getPackCubic()).isEqualTo(UPDATED_PACK_CUBIC);
        assertThat(testBrakeDisc.getoD()).isEqualTo(UPDATED_O_D);
        assertThat(testBrakeDisc.getbHC()).isEqualTo(UPDATED_B_HC);
        assertThat(testBrakeDisc.getbHQty()).isEqualTo(UPDATED_B_H_QTY);
        assertThat(testBrakeDisc.getbHSize()).isEqualTo(UPDATED_B_H_SIZE);
        assertThat(testBrakeDisc.getbHOD()).isEqualTo(UPDATED_B_HOD);
        assertThat(testBrakeDisc.getbHStep()).isEqualTo(UPDATED_B_H_STEP);
        assertThat(testBrakeDisc.getbHType()).isEqualTo(UPDATED_B_H_TYPE);
        assertThat(testBrakeDisc.getThickness()).isEqualTo(UPDATED_THICKNESS);
        assertThat(testBrakeDisc.getThicknessMin()).isEqualTo(UPDATED_THICKNESS_MIN);
        assertThat(testBrakeDisc.getOffset()).isEqualTo(UPDATED_OFFSET);
        assertThat(testBrakeDisc.getBrakeAreawidth()).isEqualTo(UPDATED_BRAKE_AREAWIDTH);
        assertThat(testBrakeDisc.gettUVLHC()).isEqualTo(UPDATED_T_UVLHC);
        assertThat(testBrakeDisc.getCustomerNotes()).isEqualTo(UPDATED_CUSTOMER_NOTES);
        assertThat(testBrakeDisc.geteListing()).isEqualTo(UPDATED_E_LISTING);
        assertThat(testBrakeDisc.getEforMake()).isEqualTo(UPDATED_EFOR_MAKE);
        assertThat(testBrakeDisc.geteDate()).isEqualTo(UPDATED_E_DATE);
        assertThat(testBrakeDisc.getEuploadedNeto()).isEqualTo(UPDATED_EUPLOADED_NETO);
        assertThat(testBrakeDisc.getEcheck()).isEqualTo(UPDATED_ECHECK);
        assertThat(testBrakeDisc.getEuploadedeBay()).isEqualTo(UPDATED_EUPLOADEDE_BAY);
        assertThat(testBrakeDisc.getEbayactive()).isEqualTo(UPDATED_EBAYACTIVE);
        assertThat(testBrakeDisc.getePhotobucket()).isEqualTo(UPDATED_E_PHOTOBUCKET);
        assertThat(testBrakeDisc.getePhoto1()).isEqualTo(UPDATED_E_PHOTO_1);
        assertThat(testBrakeDisc.getePhoto2()).isEqualTo(UPDATED_E_PHOTO_2);
        assertThat(testBrakeDisc.getePhoto3()).isEqualTo(UPDATED_E_PHOTO_3);
        assertThat(testBrakeDisc.getSaleStatus()).isEqualTo(UPDATED_SALE_STATUS);
        assertThat(testBrakeDisc.getrRP()).isEqualTo(UPDATED_R_RP);
        assertThat(testBrakeDisc.getTrade1()).isEqualTo(UPDATED_TRADE_1);
        assertThat(testBrakeDisc.geteBAY()).isEqualTo(UPDATED_E_BAY);
        assertThat(testBrakeDisc.getTrade2()).isEqualTo(UPDATED_TRADE_2);
        assertThat(testBrakeDisc.getTrade3()).isEqualTo(UPDATED_TRADE_3);
        assertThat(testBrakeDisc.getDistributorNZAUD()).isEqualTo(UPDATED_DISTRIBUTOR_NZAUD);
        assertThat(testBrakeDisc.getDistributorEUR()).isEqualTo(UPDATED_DISTRIBUTOR_EUR);
        assertThat(testBrakeDisc.getDistributorUSD()).isEqualTo(UPDATED_DISTRIBUTOR_USD);
        assertThat(testBrakeDisc.getsPriority()).isEqualTo(UPDATED_S_PRIORITY);
        assertThat(testBrakeDisc.getSamplefrom()).isEqualTo(UPDATED_SAMPLEFROM);
        assertThat(testBrakeDisc.getRequestedfrom()).isEqualTo(UPDATED_REQUESTEDFROM);
        assertThat(testBrakeDisc.getDate()).isEqualTo(UPDATED_DATE);
        assertThat(testBrakeDisc.getReceived()).isEqualTo(UPDATED_RECEIVED);
        assertThat(testBrakeDisc.getCamefrom()).isEqualTo(UPDATED_CAMEFROM);
        assertThat(testBrakeDisc.getPaidfor()).isEqualTo(UPDATED_PAIDFOR);
        assertThat(testBrakeDisc.getSentto()).isEqualTo(UPDATED_SENTTO);
        assertThat(testBrakeDisc.getShipNo()).isEqualTo(UPDATED_SHIP_NO);
        assertThat(testBrakeDisc.getDatesent()).isEqualTo(UPDATED_DATESENT);
        assertThat(testBrakeDisc.getSamplereturn()).isEqualTo(UPDATED_SAMPLERETURN);
        assertThat(testBrakeDisc.getMake()).isEqualTo(UPDATED_MAKE);
        assertThat(testBrakeDisc.getModel()).isEqualTo(UPDATED_MODEL);
        assertThat(testBrakeDisc.getYear()).isEqualTo(UPDATED_YEAR);
        assertThat(testBrakeDisc.getSampleFitment()).isEqualTo(UPDATED_SAMPLE_FITMENT);
        assertThat(testBrakeDisc.getoEM()).isEqualTo(UPDATED_O_EM);
        assertThat(testBrakeDisc.getNotesforProduction()).isEqualTo(UPDATED_NOTESFOR_PRODUCTION);
        assertThat(testBrakeDisc.getProductionCode()).isEqualTo(UPDATED_PRODUCTION_CODE);
        assertThat(testBrakeDisc.gethAPapproved()).isEqualTo(UPDATED_H_A_PAPPROVED);
        assertThat(testBrakeDisc.getsHAapproved()).isEqualTo(UPDATED_S_H_AAPPROVED);
        assertThat(testBrakeDisc.getApprovedby()).isEqualTo(UPDATED_APPROVEDBY);
        assertThat(testBrakeDisc.getNotestoDrawing()).isEqualTo(UPDATED_NOTESTO_DRAWING);
        assertThat(testBrakeDisc.getFilename()).isEqualTo(UPDATED_FILENAME);
        assertThat(testBrakeDisc.getcOSTUSD()).isEqualTo(UPDATED_C_OSTUSD);
        assertThat(testBrakeDisc.getCentrecolour()).isEqualTo(UPDATED_CENTRECOLOUR);
        assertThat(testBrakeDisc.getLaser()).isEqualTo(UPDATED_LASER);
        assertThat(testBrakeDisc.getqTY1()).isEqualTo(UPDATED_Q_TY_1);
        assertThat(testBrakeDisc.getuSD()).isEqualTo(UPDATED_U_SD);
        assertThat(testBrakeDisc.getCompleteProduction()).isEqualTo(UPDATED_COMPLETE_PRODUCTION);
        assertThat(testBrakeDisc.getOurNotetoProduction()).isEqualTo(UPDATED_OUR_NOTETO_PRODUCTION);
    }

    @Test
    @Transactional
    public void updateNonExistingBrakeDisc() throws Exception {
        int databaseSizeBeforeUpdate = brakeDiscRepository.findAll().size();

        // Create the BrakeDisc
        BrakeDiscDTO brakeDiscDTO = brakeDiscMapper.toDto(brakeDisc);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBrakeDiscMockMvc.perform(put("/api/brake-discs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(brakeDiscDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BrakeDisc in the database
        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBrakeDisc() throws Exception {
        // Initialize the database
        brakeDiscRepository.saveAndFlush(brakeDisc);

        int databaseSizeBeforeDelete = brakeDiscRepository.findAll().size();

        // Get the brakeDisc
        restBrakeDiscMockMvc.perform(delete("/api/brake-discs/{id}", brakeDisc.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BrakeDisc> brakeDiscList = brakeDiscRepository.findAll();
        assertThat(brakeDiscList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BrakeDisc.class);
        BrakeDisc brakeDisc1 = new BrakeDisc();
        brakeDisc1.setId(1L);
        BrakeDisc brakeDisc2 = new BrakeDisc();
        brakeDisc2.setId(brakeDisc1.getId());
        assertThat(brakeDisc1).isEqualTo(brakeDisc2);
        brakeDisc2.setId(2L);
        assertThat(brakeDisc1).isNotEqualTo(brakeDisc2);
        brakeDisc1.setId(null);
        assertThat(brakeDisc1).isNotEqualTo(brakeDisc2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BrakeDiscDTO.class);
        BrakeDiscDTO brakeDiscDTO1 = new BrakeDiscDTO();
        brakeDiscDTO1.setId(1L);
        BrakeDiscDTO brakeDiscDTO2 = new BrakeDiscDTO();
        assertThat(brakeDiscDTO1).isNotEqualTo(brakeDiscDTO2);
        brakeDiscDTO2.setId(brakeDiscDTO1.getId());
        assertThat(brakeDiscDTO1).isEqualTo(brakeDiscDTO2);
        brakeDiscDTO2.setId(2L);
        assertThat(brakeDiscDTO1).isNotEqualTo(brakeDiscDTO2);
        brakeDiscDTO1.setId(null);
        assertThat(brakeDiscDTO1).isNotEqualTo(brakeDiscDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(brakeDiscMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(brakeDiscMapper.fromId(null)).isNull();
    }
}
