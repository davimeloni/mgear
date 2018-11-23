package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.Sprocket;
import com.mgearapp.repository.SprocketRepository;
import com.mgearapp.service.SprocketService;
import com.mgearapp.service.dto.SprocketDTO;
import com.mgearapp.service.mapper.SprocketMapper;
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
 * Test class for the SprocketResource REST controller.
 *
 * @see SprocketResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class SprocketResourceIntTest {

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

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_GROUP_1 = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_GROUP_1 = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_GROUP_2 = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_GROUP_2 = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRIES = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRIES = "BBBBBBBBBB";

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

    private static final String DEFAULT_FITS_MAKES = "AAAAAAAAAA";
    private static final String UPDATED_FITS_MAKES = "BBBBBBBBBB";

    private static final Long DEFAULT_MODELSUPTO = 1L;
    private static final Long UPDATED_MODELSUPTO = 2L;

    private static final Long DEFAULT_G_S_1_EAN = 1L;
    private static final Long UPDATED_G_S_1_EAN = 2L;

    private static final String DEFAULT_OUR_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_OUR_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NOTES = "BBBBBBBBBB";

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

    private static final Long DEFAULT_SPROCKET_CHAIN_SIZE = 1L;
    private static final Long UPDATED_SPROCKET_CHAIN_SIZE = 2L;

    private static final Long DEFAULT_SPROCKET_TEETH = 1L;
    private static final Long UPDATED_SPROCKET_TEETH = 2L;

    private static final String DEFAULT_E_SBHC = "AAAAAAAAAA";
    private static final String UPDATED_E_SBHC = "BBBBBBBBBB";

    private static final Long DEFAULT_E_SID = 1L;
    private static final Long UPDATED_E_SID = 2L;

    private static final String DEFAULT_E_SI_DINNER_TEETH = "AAAAAAAAAA";
    private static final String UPDATED_E_SI_DINNER_TEETH = "BBBBBBBBBB";

    private static final Long DEFAULT_E_SBH_QTY = 1L;
    private static final Long UPDATED_E_SBH_QTY = 2L;

    private static final String DEFAULT_E_SBH_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_E_SBH_SIZE = "BBBBBBBBBB";

    private static final String DEFAULT_E_SBH_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_E_SBH_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_E_S_WIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_E_S_WIDTH = new BigDecimal(2);

    private static final String DEFAULT_TOLISTON_EBAY = "AAAAAAAAAA";
    private static final String UPDATED_TOLISTON_EBAY = "BBBBBBBBBB";

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

    private static final String DEFAULT_E_BAYACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_E_BAYACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTOBUCKET = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTOBUCKET = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_MAIN = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_MAIN = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_CLEAR = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_CLEAR = "BBBBBBBBBB";

    private static final String DEFAULT_E_PHOTO_SIDE = "AAAAAAAAAA";
    private static final String UPDATED_E_PHOTO_SIDE = "BBBBBBBBBB";

    private static final String DEFAULT_SALES_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_SALES_STATUS = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_R_RP = new BigDecimal(1);
    private static final BigDecimal UPDATED_R_RP = new BigDecimal(2);

    private static final BigDecimal DEFAULT_E_BAY = new BigDecimal(1);
    private static final BigDecimal UPDATED_E_BAY = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_1 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_1 = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_2 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_2 = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TRADE_3 = new BigDecimal(1);
    private static final BigDecimal UPDATED_TRADE_3 = new BigDecimal(2);

    private static final String DEFAULT_DISTRIBUTOR_NZAUD = "AAAAAAAAAA";
    private static final String UPDATED_DISTRIBUTOR_NZAUD = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRIBUTOR_USD = "AAAAAAAAAA";
    private static final String UPDATED_DISTRIBUTOR_USD = "BBBBBBBBBB";

    private static final String DEFAULT_DISTRIBUTOR_EUR = "AAAAAAAAAA";
    private static final String UPDATED_DISTRIBUTOR_EUR = "BBBBBBBBBB";

    private static final String DEFAULT_BIKEMATE_AUD = "AAAAAAAAAA";
    private static final String UPDATED_BIKEMATE_AUD = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_METAL_GEAR = "AAAAAAAAAA";
    private static final String UPDATED_COMP_METAL_GEAR = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_MOGEMA = "AAAAAAAAAA";
    private static final String UPDATED_COMP_MOGEMA = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_JT = "AAAAAAAAAA";
    private static final String UPDATED_COMP_JT = "BBBBBBBBBB";

    private static final String DEFAULT_J_TBHC = "AAAAAAAAAA";
    private static final String UPDATED_J_TBHC = "BBBBBBBBBB";

    private static final Long DEFAULT_J_TID = 1L;
    private static final Long UPDATED_J_TID = 2L;

    private static final Long DEFAULT_J_TI_DINNER_TEETH = 1L;
    private static final Long UPDATED_J_TI_DINNER_TEETH = 2L;

    private static final String DEFAULT_J_TBH_QTY = "AAAAAAAAAA";
    private static final String UPDATED_J_TBH_QTY = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_J_TBH_SIZE = new BigDecimal(1);
    private static final BigDecimal UPDATED_J_TBH_SIZE = new BigDecimal(2);

    private static final String DEFAULT_J_TBH_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_J_TBH_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_J_T_WIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_J_T_WIDTH = new BigDecimal(2);

    private static final String DEFAULT_J_T_NOTE = "AAAAAAAAAA";
    private static final String UPDATED_J_T_NOTE = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_ESJOT = "AAAAAAAAAA";
    private static final String UPDATED_COMP_ESJOT = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_SUPER_SPROX = "AAAAAAAAAA";
    private static final String UPDATED_COMP_SUPER_SPROX = "BBBBBBBBBB";

    private static final Long DEFAULT_STOCK = 1L;
    private static final Long UPDATED_STOCK = 2L;

    private static final Long DEFAULT_MIN_STOCK = 1L;
    private static final Long UPDATED_MIN_STOCK = 2L;

    private static final Long DEFAULT_MAX_STOCK = 1L;
    private static final Long UPDATED_MAX_STOCK = 2L;

    private static final String DEFAULT_SUPPLIER = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SUPPLIER_CURRENCY = "AAAAAAAAAA";
    private static final String UPDATED_SUPPLIER_CURRENCY = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_SUPPLIER_COST = new BigDecimal(1);
    private static final BigDecimal UPDATED_SUPPLIER_COST = new BigDecimal(2);

    @Autowired
    private SprocketRepository sprocketRepository;

    @Autowired
    private SprocketMapper sprocketMapper;
    
    @Autowired
    private SprocketService sprocketService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSprocketMockMvc;

    private Sprocket sprocket;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SprocketResource sprocketResource = new SprocketResource(sprocketService);
        this.restSprocketMockMvc = MockMvcBuilders.standaloneSetup(sprocketResource)
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
    public static Sprocket createEntity(EntityManager em) {
        Sprocket sprocket = new Sprocket()
            .sku(DEFAULT_SKU)
            .active(DEFAULT_ACTIVE)
            .au(DEFAULT_AU)
            .de(DEFAULT_DE)
            .metalGearvisibility(DEFAULT_METAL_GEARVISIBILITY)
            .bikematevisibility(DEFAULT_BIKEMATEVISIBILITY)
            .mgiVisibility(DEFAULT_MGI_VISIBILITY)
            .status(DEFAULT_STATUS)
            .productGroup1(DEFAULT_PRODUCT_GROUP_1)
            .productGroup2(DEFAULT_PRODUCT_GROUP_2)
            .countries(DEFAULT_COUNTRIES)
            .fitment(DEFAULT_FITMENT)
            .description(DEFAULT_DESCRIPTION)
            .unit(DEFAULT_UNIT)
            .qty(DEFAULT_QTY)
            .brand(DEFAULT_BRAND)
            .biketypes(DEFAULT_BIKETYPES)
            .fitsMakes(DEFAULT_FITS_MAKES)
            .modelsupto(DEFAULT_MODELSUPTO)
            .gS1EAN(DEFAULT_G_S_1_EAN)
            .ourNotes(DEFAULT_OUR_NOTES)
            .customerNotes(DEFAULT_CUSTOMER_NOTES)
            .weightkg(DEFAULT_WEIGHTKG)
            .packType(DEFAULT_PACK_TYPE)
            .packLength(DEFAULT_PACK_LENGTH)
            .packWidth(DEFAULT_PACK_WIDTH)
            .packHeight(DEFAULT_PACK_HEIGHT)
            .packCubic(DEFAULT_PACK_CUBIC)
            .sprocketChainSize(DEFAULT_SPROCKET_CHAIN_SIZE)
            .sprocketTeeth(DEFAULT_SPROCKET_TEETH)
            .eSBHC(DEFAULT_E_SBHC)
            .eSID(DEFAULT_E_SID)
            .eSIDinnerTeeth(DEFAULT_E_SI_DINNER_TEETH)
            .eSBHQty(DEFAULT_E_SBH_QTY)
            .eSBHSize(DEFAULT_E_SBH_SIZE)
            .eSBHType(DEFAULT_E_SBH_TYPE)
            .eSWidth(DEFAULT_E_S_WIDTH)
            .tolistonEbay(DEFAULT_TOLISTON_EBAY)
            .eListing(DEFAULT_E_LISTING)
            .eforMake(DEFAULT_EFOR_MAKE)
            .euploadedNeto(DEFAULT_EUPLOADED_NETO)
            .eDate(DEFAULT_E_DATE)
            .echeck(DEFAULT_ECHECK)
            .euploadedeBay(DEFAULT_EUPLOADEDE_BAY)
            .eBayactive(DEFAULT_E_BAYACTIVE)
            .ePhotobucket(DEFAULT_E_PHOTOBUCKET)
            .ePhotoMain(DEFAULT_E_PHOTO_MAIN)
            .ePhotoClear(DEFAULT_E_PHOTO_CLEAR)
            .ePhotoSide(DEFAULT_E_PHOTO_SIDE)
            .salesStatus(DEFAULT_SALES_STATUS)
            .rRP(DEFAULT_R_RP)
            .eBay(DEFAULT_E_BAY)
            .trade1(DEFAULT_TRADE_1)
            .trade2(DEFAULT_TRADE_2)
            .trade3(DEFAULT_TRADE_3)
            .distributorNZAUD(DEFAULT_DISTRIBUTOR_NZAUD)
            .distributorUSD(DEFAULT_DISTRIBUTOR_USD)
            .distributorEUR(DEFAULT_DISTRIBUTOR_EUR)
            .bikemateAUD(DEFAULT_BIKEMATE_AUD)
            .compMetalGear(DEFAULT_COMP_METAL_GEAR)
            .compMogema(DEFAULT_COMP_MOGEMA)
            .compJT(DEFAULT_COMP_JT)
            .jTBHC(DEFAULT_J_TBHC)
            .jTID(DEFAULT_J_TID)
            .jTIDinnerTeeth(DEFAULT_J_TI_DINNER_TEETH)
            .jTBHQty(DEFAULT_J_TBH_QTY)
            .jTBHSize(DEFAULT_J_TBH_SIZE)
            .jTBHType(DEFAULT_J_TBH_TYPE)
            .jTWidth(DEFAULT_J_T_WIDTH)
            .jTNote(DEFAULT_J_T_NOTE)
            .compEsjot(DEFAULT_COMP_ESJOT)
            .compSuperSprox(DEFAULT_COMP_SUPER_SPROX)
            .stock(DEFAULT_STOCK)
            .minStock(DEFAULT_MIN_STOCK)
            .maxStock(DEFAULT_MAX_STOCK)
            .supplier(DEFAULT_SUPPLIER)
            .supplierCode(DEFAULT_SUPPLIER_CODE)
            .supplierCurrency(DEFAULT_SUPPLIER_CURRENCY)
            .supplierCost(DEFAULT_SUPPLIER_COST);
        return sprocket;
    }

    @Before
    public void initTest() {
        sprocket = createEntity(em);
    }

    @Test
    @Transactional
    public void createSprocket() throws Exception {
        int databaseSizeBeforeCreate = sprocketRepository.findAll().size();

        // Create the Sprocket
        SprocketDTO sprocketDTO = sprocketMapper.toDto(sprocket);
        restSprocketMockMvc.perform(post("/api/sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sprocketDTO)))
            .andExpect(status().isCreated());

        // Validate the Sprocket in the database
        List<Sprocket> sprocketList = sprocketRepository.findAll();
        assertThat(sprocketList).hasSize(databaseSizeBeforeCreate + 1);
        Sprocket testSprocket = sprocketList.get(sprocketList.size() - 1);
        assertThat(testSprocket.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(testSprocket.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testSprocket.getAu()).isEqualTo(DEFAULT_AU);
        assertThat(testSprocket.getDe()).isEqualTo(DEFAULT_DE);
        assertThat(testSprocket.getMetalGearvisibility()).isEqualTo(DEFAULT_METAL_GEARVISIBILITY);
        assertThat(testSprocket.getBikematevisibility()).isEqualTo(DEFAULT_BIKEMATEVISIBILITY);
        assertThat(testSprocket.getMgiVisibility()).isEqualTo(DEFAULT_MGI_VISIBILITY);
        assertThat(testSprocket.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testSprocket.getProductGroup1()).isEqualTo(DEFAULT_PRODUCT_GROUP_1);
        assertThat(testSprocket.getProductGroup2()).isEqualTo(DEFAULT_PRODUCT_GROUP_2);
        assertThat(testSprocket.getCountries()).isEqualTo(DEFAULT_COUNTRIES);
        assertThat(testSprocket.getFitment()).isEqualTo(DEFAULT_FITMENT);
        assertThat(testSprocket.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testSprocket.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testSprocket.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testSprocket.getBrand()).isEqualTo(DEFAULT_BRAND);
        assertThat(testSprocket.getBiketypes()).isEqualTo(DEFAULT_BIKETYPES);
        assertThat(testSprocket.getFitsMakes()).isEqualTo(DEFAULT_FITS_MAKES);
        assertThat(testSprocket.getModelsupto()).isEqualTo(DEFAULT_MODELSUPTO);
        assertThat(testSprocket.getgS1EAN()).isEqualTo(DEFAULT_G_S_1_EAN);
        assertThat(testSprocket.getOurNotes()).isEqualTo(DEFAULT_OUR_NOTES);
        assertThat(testSprocket.getCustomerNotes()).isEqualTo(DEFAULT_CUSTOMER_NOTES);
        assertThat(testSprocket.getWeightkg()).isEqualTo(DEFAULT_WEIGHTKG);
        assertThat(testSprocket.getPackType()).isEqualTo(DEFAULT_PACK_TYPE);
        assertThat(testSprocket.getPackLength()).isEqualTo(DEFAULT_PACK_LENGTH);
        assertThat(testSprocket.getPackWidth()).isEqualTo(DEFAULT_PACK_WIDTH);
        assertThat(testSprocket.getPackHeight()).isEqualTo(DEFAULT_PACK_HEIGHT);
        assertThat(testSprocket.getPackCubic()).isEqualTo(DEFAULT_PACK_CUBIC);
        assertThat(testSprocket.getSprocketChainSize()).isEqualTo(DEFAULT_SPROCKET_CHAIN_SIZE);
        assertThat(testSprocket.getSprocketTeeth()).isEqualTo(DEFAULT_SPROCKET_TEETH);
        assertThat(testSprocket.geteSBHC()).isEqualTo(DEFAULT_E_SBHC);
        assertThat(testSprocket.geteSID()).isEqualTo(DEFAULT_E_SID);
        assertThat(testSprocket.geteSIDinnerTeeth()).isEqualTo(DEFAULT_E_SI_DINNER_TEETH);
        assertThat(testSprocket.geteSBHQty()).isEqualTo(DEFAULT_E_SBH_QTY);
        assertThat(testSprocket.geteSBHSize()).isEqualTo(DEFAULT_E_SBH_SIZE);
        assertThat(testSprocket.geteSBHType()).isEqualTo(DEFAULT_E_SBH_TYPE);
        assertThat(testSprocket.geteSWidth()).isEqualTo(DEFAULT_E_S_WIDTH);
        assertThat(testSprocket.getTolistonEbay()).isEqualTo(DEFAULT_TOLISTON_EBAY);
        assertThat(testSprocket.geteListing()).isEqualTo(DEFAULT_E_LISTING);
        assertThat(testSprocket.getEforMake()).isEqualTo(DEFAULT_EFOR_MAKE);
        assertThat(testSprocket.getEuploadedNeto()).isEqualTo(DEFAULT_EUPLOADED_NETO);
        assertThat(testSprocket.geteDate()).isEqualTo(DEFAULT_E_DATE);
        assertThat(testSprocket.getEcheck()).isEqualTo(DEFAULT_ECHECK);
        assertThat(testSprocket.getEuploadedeBay()).isEqualTo(DEFAULT_EUPLOADEDE_BAY);
        assertThat(testSprocket.geteBayactive()).isEqualTo(DEFAULT_E_BAYACTIVE);
        assertThat(testSprocket.getePhotobucket()).isEqualTo(DEFAULT_E_PHOTOBUCKET);
        assertThat(testSprocket.getePhotoMain()).isEqualTo(DEFAULT_E_PHOTO_MAIN);
        assertThat(testSprocket.getePhotoClear()).isEqualTo(DEFAULT_E_PHOTO_CLEAR);
        assertThat(testSprocket.getePhotoSide()).isEqualTo(DEFAULT_E_PHOTO_SIDE);
        assertThat(testSprocket.getSalesStatus()).isEqualTo(DEFAULT_SALES_STATUS);
        assertThat(testSprocket.getrRP()).isEqualTo(DEFAULT_R_RP);
        assertThat(testSprocket.geteBay()).isEqualTo(DEFAULT_E_BAY);
        assertThat(testSprocket.getTrade1()).isEqualTo(DEFAULT_TRADE_1);
        assertThat(testSprocket.getTrade2()).isEqualTo(DEFAULT_TRADE_2);
        assertThat(testSprocket.getTrade3()).isEqualTo(DEFAULT_TRADE_3);
        assertThat(testSprocket.getDistributorNZAUD()).isEqualTo(DEFAULT_DISTRIBUTOR_NZAUD);
        assertThat(testSprocket.getDistributorUSD()).isEqualTo(DEFAULT_DISTRIBUTOR_USD);
        assertThat(testSprocket.getDistributorEUR()).isEqualTo(DEFAULT_DISTRIBUTOR_EUR);
        assertThat(testSprocket.getBikemateAUD()).isEqualTo(DEFAULT_BIKEMATE_AUD);
        assertThat(testSprocket.getCompMetalGear()).isEqualTo(DEFAULT_COMP_METAL_GEAR);
        assertThat(testSprocket.getCompMogema()).isEqualTo(DEFAULT_COMP_MOGEMA);
        assertThat(testSprocket.getCompJT()).isEqualTo(DEFAULT_COMP_JT);
        assertThat(testSprocket.getjTBHC()).isEqualTo(DEFAULT_J_TBHC);
        assertThat(testSprocket.getjTID()).isEqualTo(DEFAULT_J_TID);
        assertThat(testSprocket.getjTIDinnerTeeth()).isEqualTo(DEFAULT_J_TI_DINNER_TEETH);
        assertThat(testSprocket.getjTBHQty()).isEqualTo(DEFAULT_J_TBH_QTY);
        assertThat(testSprocket.getjTBHSize()).isEqualTo(DEFAULT_J_TBH_SIZE);
        assertThat(testSprocket.getjTBHType()).isEqualTo(DEFAULT_J_TBH_TYPE);
        assertThat(testSprocket.getjTWidth()).isEqualTo(DEFAULT_J_T_WIDTH);
        assertThat(testSprocket.getjTNote()).isEqualTo(DEFAULT_J_T_NOTE);
        assertThat(testSprocket.getCompEsjot()).isEqualTo(DEFAULT_COMP_ESJOT);
        assertThat(testSprocket.getCompSuperSprox()).isEqualTo(DEFAULT_COMP_SUPER_SPROX);
        assertThat(testSprocket.getStock()).isEqualTo(DEFAULT_STOCK);
        assertThat(testSprocket.getMinStock()).isEqualTo(DEFAULT_MIN_STOCK);
        assertThat(testSprocket.getMaxStock()).isEqualTo(DEFAULT_MAX_STOCK);
        assertThat(testSprocket.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testSprocket.getSupplierCode()).isEqualTo(DEFAULT_SUPPLIER_CODE);
        assertThat(testSprocket.getSupplierCurrency()).isEqualTo(DEFAULT_SUPPLIER_CURRENCY);
        assertThat(testSprocket.getSupplierCost()).isEqualTo(DEFAULT_SUPPLIER_COST);
    }

    @Test
    @Transactional
    public void createSprocketWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sprocketRepository.findAll().size();

        // Create the Sprocket with an existing ID
        sprocket.setId(1L);
        SprocketDTO sprocketDTO = sprocketMapper.toDto(sprocket);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSprocketMockMvc.perform(post("/api/sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sprocket in the database
        List<Sprocket> sprocketList = sprocketRepository.findAll();
        assertThat(sprocketList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllSprockets() throws Exception {
        // Initialize the database
        sprocketRepository.saveAndFlush(sprocket);

        // Get all the sprocketList
        restSprocketMockMvc.perform(get("/api/sprockets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sprocket.getId().intValue())))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU.toString())))
            .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE.toString())))
            .andExpect(jsonPath("$.[*].au").value(hasItem(DEFAULT_AU.toString())))
            .andExpect(jsonPath("$.[*].de").value(hasItem(DEFAULT_DE.toString())))
            .andExpect(jsonPath("$.[*].metalGearvisibility").value(hasItem(DEFAULT_METAL_GEARVISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].bikematevisibility").value(hasItem(DEFAULT_BIKEMATEVISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].mgiVisibility").value(hasItem(DEFAULT_MGI_VISIBILITY.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].productGroup1").value(hasItem(DEFAULT_PRODUCT_GROUP_1.toString())))
            .andExpect(jsonPath("$.[*].productGroup2").value(hasItem(DEFAULT_PRODUCT_GROUP_2.toString())))
            .andExpect(jsonPath("$.[*].countries").value(hasItem(DEFAULT_COUNTRIES.toString())))
            .andExpect(jsonPath("$.[*].fitment").value(hasItem(DEFAULT_FITMENT.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.toString())))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY.intValue())))
            .andExpect(jsonPath("$.[*].brand").value(hasItem(DEFAULT_BRAND.toString())))
            .andExpect(jsonPath("$.[*].biketypes").value(hasItem(DEFAULT_BIKETYPES.toString())))
            .andExpect(jsonPath("$.[*].fitsMakes").value(hasItem(DEFAULT_FITS_MAKES.toString())))
            .andExpect(jsonPath("$.[*].modelsupto").value(hasItem(DEFAULT_MODELSUPTO.intValue())))
            .andExpect(jsonPath("$.[*].gS1EAN").value(hasItem(DEFAULT_G_S_1_EAN.intValue())))
            .andExpect(jsonPath("$.[*].ourNotes").value(hasItem(DEFAULT_OUR_NOTES.toString())))
            .andExpect(jsonPath("$.[*].customerNotes").value(hasItem(DEFAULT_CUSTOMER_NOTES.toString())))
            .andExpect(jsonPath("$.[*].weightkg").value(hasItem(DEFAULT_WEIGHTKG.intValue())))
            .andExpect(jsonPath("$.[*].packType").value(hasItem(DEFAULT_PACK_TYPE.toString())))
            .andExpect(jsonPath("$.[*].packLength").value(hasItem(DEFAULT_PACK_LENGTH.intValue())))
            .andExpect(jsonPath("$.[*].packWidth").value(hasItem(DEFAULT_PACK_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].packHeight").value(hasItem(DEFAULT_PACK_HEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].packCubic").value(hasItem(DEFAULT_PACK_CUBIC.intValue())))
            .andExpect(jsonPath("$.[*].sprocketChainSize").value(hasItem(DEFAULT_SPROCKET_CHAIN_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].sprocketTeeth").value(hasItem(DEFAULT_SPROCKET_TEETH.intValue())))
            .andExpect(jsonPath("$.[*].eSBHC").value(hasItem(DEFAULT_E_SBHC.toString())))
            .andExpect(jsonPath("$.[*].eSID").value(hasItem(DEFAULT_E_SID.intValue())))
            .andExpect(jsonPath("$.[*].eSIDinnerTeeth").value(hasItem(DEFAULT_E_SI_DINNER_TEETH.toString())))
            .andExpect(jsonPath("$.[*].eSBHQty").value(hasItem(DEFAULT_E_SBH_QTY.intValue())))
            .andExpect(jsonPath("$.[*].eSBHSize").value(hasItem(DEFAULT_E_SBH_SIZE.toString())))
            .andExpect(jsonPath("$.[*].eSBHType").value(hasItem(DEFAULT_E_SBH_TYPE.toString())))
            .andExpect(jsonPath("$.[*].eSWidth").value(hasItem(DEFAULT_E_S_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].tolistonEbay").value(hasItem(DEFAULT_TOLISTON_EBAY.toString())))
            .andExpect(jsonPath("$.[*].eListing").value(hasItem(DEFAULT_E_LISTING.toString())))
            .andExpect(jsonPath("$.[*].eforMake").value(hasItem(DEFAULT_EFOR_MAKE.toString())))
            .andExpect(jsonPath("$.[*].euploadedNeto").value(hasItem(DEFAULT_EUPLOADED_NETO.toString())))
            .andExpect(jsonPath("$.[*].eDate").value(hasItem(DEFAULT_E_DATE.toString())))
            .andExpect(jsonPath("$.[*].echeck").value(hasItem(DEFAULT_ECHECK.toString())))
            .andExpect(jsonPath("$.[*].euploadedeBay").value(hasItem(DEFAULT_EUPLOADEDE_BAY.toString())))
            .andExpect(jsonPath("$.[*].eBayactive").value(hasItem(DEFAULT_E_BAYACTIVE.toString())))
            .andExpect(jsonPath("$.[*].ePhotobucket").value(hasItem(DEFAULT_E_PHOTOBUCKET.toString())))
            .andExpect(jsonPath("$.[*].ePhotoMain").value(hasItem(DEFAULT_E_PHOTO_MAIN.toString())))
            .andExpect(jsonPath("$.[*].ePhotoClear").value(hasItem(DEFAULT_E_PHOTO_CLEAR.toString())))
            .andExpect(jsonPath("$.[*].ePhotoSide").value(hasItem(DEFAULT_E_PHOTO_SIDE.toString())))
            .andExpect(jsonPath("$.[*].salesStatus").value(hasItem(DEFAULT_SALES_STATUS.toString())))
            .andExpect(jsonPath("$.[*].rRP").value(hasItem(DEFAULT_R_RP.intValue())))
            .andExpect(jsonPath("$.[*].eBay").value(hasItem(DEFAULT_E_BAY.intValue())))
            .andExpect(jsonPath("$.[*].trade1").value(hasItem(DEFAULT_TRADE_1.intValue())))
            .andExpect(jsonPath("$.[*].trade2").value(hasItem(DEFAULT_TRADE_2.intValue())))
            .andExpect(jsonPath("$.[*].trade3").value(hasItem(DEFAULT_TRADE_3.intValue())))
            .andExpect(jsonPath("$.[*].distributorNZAUD").value(hasItem(DEFAULT_DISTRIBUTOR_NZAUD.toString())))
            .andExpect(jsonPath("$.[*].distributorUSD").value(hasItem(DEFAULT_DISTRIBUTOR_USD.toString())))
            .andExpect(jsonPath("$.[*].distributorEUR").value(hasItem(DEFAULT_DISTRIBUTOR_EUR.toString())))
            .andExpect(jsonPath("$.[*].bikemateAUD").value(hasItem(DEFAULT_BIKEMATE_AUD.toString())))
            .andExpect(jsonPath("$.[*].compMetalGear").value(hasItem(DEFAULT_COMP_METAL_GEAR.toString())))
            .andExpect(jsonPath("$.[*].compMogema").value(hasItem(DEFAULT_COMP_MOGEMA.toString())))
            .andExpect(jsonPath("$.[*].compJT").value(hasItem(DEFAULT_COMP_JT.toString())))
            .andExpect(jsonPath("$.[*].jTBHC").value(hasItem(DEFAULT_J_TBHC.toString())))
            .andExpect(jsonPath("$.[*].jTID").value(hasItem(DEFAULT_J_TID.intValue())))
            .andExpect(jsonPath("$.[*].jTIDinnerTeeth").value(hasItem(DEFAULT_J_TI_DINNER_TEETH.intValue())))
            .andExpect(jsonPath("$.[*].jTBHQty").value(hasItem(DEFAULT_J_TBH_QTY.toString())))
            .andExpect(jsonPath("$.[*].jTBHSize").value(hasItem(DEFAULT_J_TBH_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].jTBHType").value(hasItem(DEFAULT_J_TBH_TYPE.toString())))
            .andExpect(jsonPath("$.[*].jTWidth").value(hasItem(DEFAULT_J_T_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].jTNote").value(hasItem(DEFAULT_J_T_NOTE.toString())))
            .andExpect(jsonPath("$.[*].compEsjot").value(hasItem(DEFAULT_COMP_ESJOT.toString())))
            .andExpect(jsonPath("$.[*].compSuperSprox").value(hasItem(DEFAULT_COMP_SUPER_SPROX.toString())))
            .andExpect(jsonPath("$.[*].stock").value(hasItem(DEFAULT_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].minStock").value(hasItem(DEFAULT_MIN_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].maxStock").value(hasItem(DEFAULT_MAX_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].supplier").value(hasItem(DEFAULT_SUPPLIER.toString())))
            .andExpect(jsonPath("$.[*].supplierCode").value(hasItem(DEFAULT_SUPPLIER_CODE.toString())))
            .andExpect(jsonPath("$.[*].supplierCurrency").value(hasItem(DEFAULT_SUPPLIER_CURRENCY.toString())))
            .andExpect(jsonPath("$.[*].supplierCost").value(hasItem(DEFAULT_SUPPLIER_COST.intValue())));
    }
    
    @Test
    @Transactional
    public void getSprocket() throws Exception {
        // Initialize the database
        sprocketRepository.saveAndFlush(sprocket);

        // Get the sprocket
        restSprocketMockMvc.perform(get("/api/sprockets/{id}", sprocket.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sprocket.getId().intValue()))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU.toString()))
            .andExpect(jsonPath("$.active").value(DEFAULT_ACTIVE.toString()))
            .andExpect(jsonPath("$.au").value(DEFAULT_AU.toString()))
            .andExpect(jsonPath("$.de").value(DEFAULT_DE.toString()))
            .andExpect(jsonPath("$.metalGearvisibility").value(DEFAULT_METAL_GEARVISIBILITY.toString()))
            .andExpect(jsonPath("$.bikematevisibility").value(DEFAULT_BIKEMATEVISIBILITY.toString()))
            .andExpect(jsonPath("$.mgiVisibility").value(DEFAULT_MGI_VISIBILITY.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.productGroup1").value(DEFAULT_PRODUCT_GROUP_1.toString()))
            .andExpect(jsonPath("$.productGroup2").value(DEFAULT_PRODUCT_GROUP_2.toString()))
            .andExpect(jsonPath("$.countries").value(DEFAULT_COUNTRIES.toString()))
            .andExpect(jsonPath("$.fitment").value(DEFAULT_FITMENT.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.toString()))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY.intValue()))
            .andExpect(jsonPath("$.brand").value(DEFAULT_BRAND.toString()))
            .andExpect(jsonPath("$.biketypes").value(DEFAULT_BIKETYPES.toString()))
            .andExpect(jsonPath("$.fitsMakes").value(DEFAULT_FITS_MAKES.toString()))
            .andExpect(jsonPath("$.modelsupto").value(DEFAULT_MODELSUPTO.intValue()))
            .andExpect(jsonPath("$.gS1EAN").value(DEFAULT_G_S_1_EAN.intValue()))
            .andExpect(jsonPath("$.ourNotes").value(DEFAULT_OUR_NOTES.toString()))
            .andExpect(jsonPath("$.customerNotes").value(DEFAULT_CUSTOMER_NOTES.toString()))
            .andExpect(jsonPath("$.weightkg").value(DEFAULT_WEIGHTKG.intValue()))
            .andExpect(jsonPath("$.packType").value(DEFAULT_PACK_TYPE.toString()))
            .andExpect(jsonPath("$.packLength").value(DEFAULT_PACK_LENGTH.intValue()))
            .andExpect(jsonPath("$.packWidth").value(DEFAULT_PACK_WIDTH.intValue()))
            .andExpect(jsonPath("$.packHeight").value(DEFAULT_PACK_HEIGHT.intValue()))
            .andExpect(jsonPath("$.packCubic").value(DEFAULT_PACK_CUBIC.intValue()))
            .andExpect(jsonPath("$.sprocketChainSize").value(DEFAULT_SPROCKET_CHAIN_SIZE.intValue()))
            .andExpect(jsonPath("$.sprocketTeeth").value(DEFAULT_SPROCKET_TEETH.intValue()))
            .andExpect(jsonPath("$.eSBHC").value(DEFAULT_E_SBHC.toString()))
            .andExpect(jsonPath("$.eSID").value(DEFAULT_E_SID.intValue()))
            .andExpect(jsonPath("$.eSIDinnerTeeth").value(DEFAULT_E_SI_DINNER_TEETH.toString()))
            .andExpect(jsonPath("$.eSBHQty").value(DEFAULT_E_SBH_QTY.intValue()))
            .andExpect(jsonPath("$.eSBHSize").value(DEFAULT_E_SBH_SIZE.toString()))
            .andExpect(jsonPath("$.eSBHType").value(DEFAULT_E_SBH_TYPE.toString()))
            .andExpect(jsonPath("$.eSWidth").value(DEFAULT_E_S_WIDTH.intValue()))
            .andExpect(jsonPath("$.tolistonEbay").value(DEFAULT_TOLISTON_EBAY.toString()))
            .andExpect(jsonPath("$.eListing").value(DEFAULT_E_LISTING.toString()))
            .andExpect(jsonPath("$.eforMake").value(DEFAULT_EFOR_MAKE.toString()))
            .andExpect(jsonPath("$.euploadedNeto").value(DEFAULT_EUPLOADED_NETO.toString()))
            .andExpect(jsonPath("$.eDate").value(DEFAULT_E_DATE.toString()))
            .andExpect(jsonPath("$.echeck").value(DEFAULT_ECHECK.toString()))
            .andExpect(jsonPath("$.euploadedeBay").value(DEFAULT_EUPLOADEDE_BAY.toString()))
            .andExpect(jsonPath("$.eBayactive").value(DEFAULT_E_BAYACTIVE.toString()))
            .andExpect(jsonPath("$.ePhotobucket").value(DEFAULT_E_PHOTOBUCKET.toString()))
            .andExpect(jsonPath("$.ePhotoMain").value(DEFAULT_E_PHOTO_MAIN.toString()))
            .andExpect(jsonPath("$.ePhotoClear").value(DEFAULT_E_PHOTO_CLEAR.toString()))
            .andExpect(jsonPath("$.ePhotoSide").value(DEFAULT_E_PHOTO_SIDE.toString()))
            .andExpect(jsonPath("$.salesStatus").value(DEFAULT_SALES_STATUS.toString()))
            .andExpect(jsonPath("$.rRP").value(DEFAULT_R_RP.intValue()))
            .andExpect(jsonPath("$.eBay").value(DEFAULT_E_BAY.intValue()))
            .andExpect(jsonPath("$.trade1").value(DEFAULT_TRADE_1.intValue()))
            .andExpect(jsonPath("$.trade2").value(DEFAULT_TRADE_2.intValue()))
            .andExpect(jsonPath("$.trade3").value(DEFAULT_TRADE_3.intValue()))
            .andExpect(jsonPath("$.distributorNZAUD").value(DEFAULT_DISTRIBUTOR_NZAUD.toString()))
            .andExpect(jsonPath("$.distributorUSD").value(DEFAULT_DISTRIBUTOR_USD.toString()))
            .andExpect(jsonPath("$.distributorEUR").value(DEFAULT_DISTRIBUTOR_EUR.toString()))
            .andExpect(jsonPath("$.bikemateAUD").value(DEFAULT_BIKEMATE_AUD.toString()))
            .andExpect(jsonPath("$.compMetalGear").value(DEFAULT_COMP_METAL_GEAR.toString()))
            .andExpect(jsonPath("$.compMogema").value(DEFAULT_COMP_MOGEMA.toString()))
            .andExpect(jsonPath("$.compJT").value(DEFAULT_COMP_JT.toString()))
            .andExpect(jsonPath("$.jTBHC").value(DEFAULT_J_TBHC.toString()))
            .andExpect(jsonPath("$.jTID").value(DEFAULT_J_TID.intValue()))
            .andExpect(jsonPath("$.jTIDinnerTeeth").value(DEFAULT_J_TI_DINNER_TEETH.intValue()))
            .andExpect(jsonPath("$.jTBHQty").value(DEFAULT_J_TBH_QTY.toString()))
            .andExpect(jsonPath("$.jTBHSize").value(DEFAULT_J_TBH_SIZE.intValue()))
            .andExpect(jsonPath("$.jTBHType").value(DEFAULT_J_TBH_TYPE.toString()))
            .andExpect(jsonPath("$.jTWidth").value(DEFAULT_J_T_WIDTH.intValue()))
            .andExpect(jsonPath("$.jTNote").value(DEFAULT_J_T_NOTE.toString()))
            .andExpect(jsonPath("$.compEsjot").value(DEFAULT_COMP_ESJOT.toString()))
            .andExpect(jsonPath("$.compSuperSprox").value(DEFAULT_COMP_SUPER_SPROX.toString()))
            .andExpect(jsonPath("$.stock").value(DEFAULT_STOCK.intValue()))
            .andExpect(jsonPath("$.minStock").value(DEFAULT_MIN_STOCK.intValue()))
            .andExpect(jsonPath("$.maxStock").value(DEFAULT_MAX_STOCK.intValue()))
            .andExpect(jsonPath("$.supplier").value(DEFAULT_SUPPLIER.toString()))
            .andExpect(jsonPath("$.supplierCode").value(DEFAULT_SUPPLIER_CODE.toString()))
            .andExpect(jsonPath("$.supplierCurrency").value(DEFAULT_SUPPLIER_CURRENCY.toString()))
            .andExpect(jsonPath("$.supplierCost").value(DEFAULT_SUPPLIER_COST.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSprocket() throws Exception {
        // Get the sprocket
        restSprocketMockMvc.perform(get("/api/sprockets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSprocket() throws Exception {
        // Initialize the database
        sprocketRepository.saveAndFlush(sprocket);

        int databaseSizeBeforeUpdate = sprocketRepository.findAll().size();

        // Update the sprocket
        Sprocket updatedSprocket = sprocketRepository.findById(sprocket.getId()).get();
        // Disconnect from session so that the updates on updatedSprocket are not directly saved in db
        em.detach(updatedSprocket);
        updatedSprocket
            .sku(UPDATED_SKU)
            .active(UPDATED_ACTIVE)
            .au(UPDATED_AU)
            .de(UPDATED_DE)
            .metalGearvisibility(UPDATED_METAL_GEARVISIBILITY)
            .bikematevisibility(UPDATED_BIKEMATEVISIBILITY)
            .mgiVisibility(UPDATED_MGI_VISIBILITY)
            .status(UPDATED_STATUS)
            .productGroup1(UPDATED_PRODUCT_GROUP_1)
            .productGroup2(UPDATED_PRODUCT_GROUP_2)
            .countries(UPDATED_COUNTRIES)
            .fitment(UPDATED_FITMENT)
            .description(UPDATED_DESCRIPTION)
            .unit(UPDATED_UNIT)
            .qty(UPDATED_QTY)
            .brand(UPDATED_BRAND)
            .biketypes(UPDATED_BIKETYPES)
            .fitsMakes(UPDATED_FITS_MAKES)
            .modelsupto(UPDATED_MODELSUPTO)
            .gS1EAN(UPDATED_G_S_1_EAN)
            .ourNotes(UPDATED_OUR_NOTES)
            .customerNotes(UPDATED_CUSTOMER_NOTES)
            .weightkg(UPDATED_WEIGHTKG)
            .packType(UPDATED_PACK_TYPE)
            .packLength(UPDATED_PACK_LENGTH)
            .packWidth(UPDATED_PACK_WIDTH)
            .packHeight(UPDATED_PACK_HEIGHT)
            .packCubic(UPDATED_PACK_CUBIC)
            .sprocketChainSize(UPDATED_SPROCKET_CHAIN_SIZE)
            .sprocketTeeth(UPDATED_SPROCKET_TEETH)
            .eSBHC(UPDATED_E_SBHC)
            .eSID(UPDATED_E_SID)
            .eSIDinnerTeeth(UPDATED_E_SI_DINNER_TEETH)
            .eSBHQty(UPDATED_E_SBH_QTY)
            .eSBHSize(UPDATED_E_SBH_SIZE)
            .eSBHType(UPDATED_E_SBH_TYPE)
            .eSWidth(UPDATED_E_S_WIDTH)
            .tolistonEbay(UPDATED_TOLISTON_EBAY)
            .eListing(UPDATED_E_LISTING)
            .eforMake(UPDATED_EFOR_MAKE)
            .euploadedNeto(UPDATED_EUPLOADED_NETO)
            .eDate(UPDATED_E_DATE)
            .echeck(UPDATED_ECHECK)
            .euploadedeBay(UPDATED_EUPLOADEDE_BAY)
            .eBayactive(UPDATED_E_BAYACTIVE)
            .ePhotobucket(UPDATED_E_PHOTOBUCKET)
            .ePhotoMain(UPDATED_E_PHOTO_MAIN)
            .ePhotoClear(UPDATED_E_PHOTO_CLEAR)
            .ePhotoSide(UPDATED_E_PHOTO_SIDE)
            .salesStatus(UPDATED_SALES_STATUS)
            .rRP(UPDATED_R_RP)
            .eBay(UPDATED_E_BAY)
            .trade1(UPDATED_TRADE_1)
            .trade2(UPDATED_TRADE_2)
            .trade3(UPDATED_TRADE_3)
            .distributorNZAUD(UPDATED_DISTRIBUTOR_NZAUD)
            .distributorUSD(UPDATED_DISTRIBUTOR_USD)
            .distributorEUR(UPDATED_DISTRIBUTOR_EUR)
            .bikemateAUD(UPDATED_BIKEMATE_AUD)
            .compMetalGear(UPDATED_COMP_METAL_GEAR)
            .compMogema(UPDATED_COMP_MOGEMA)
            .compJT(UPDATED_COMP_JT)
            .jTBHC(UPDATED_J_TBHC)
            .jTID(UPDATED_J_TID)
            .jTIDinnerTeeth(UPDATED_J_TI_DINNER_TEETH)
            .jTBHQty(UPDATED_J_TBH_QTY)
            .jTBHSize(UPDATED_J_TBH_SIZE)
            .jTBHType(UPDATED_J_TBH_TYPE)
            .jTWidth(UPDATED_J_T_WIDTH)
            .jTNote(UPDATED_J_T_NOTE)
            .compEsjot(UPDATED_COMP_ESJOT)
            .compSuperSprox(UPDATED_COMP_SUPER_SPROX)
            .stock(UPDATED_STOCK)
            .minStock(UPDATED_MIN_STOCK)
            .maxStock(UPDATED_MAX_STOCK)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .supplierCurrency(UPDATED_SUPPLIER_CURRENCY)
            .supplierCost(UPDATED_SUPPLIER_COST);
        SprocketDTO sprocketDTO = sprocketMapper.toDto(updatedSprocket);

        restSprocketMockMvc.perform(put("/api/sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sprocketDTO)))
            .andExpect(status().isOk());

        // Validate the Sprocket in the database
        List<Sprocket> sprocketList = sprocketRepository.findAll();
        assertThat(sprocketList).hasSize(databaseSizeBeforeUpdate);
        Sprocket testSprocket = sprocketList.get(sprocketList.size() - 1);
        assertThat(testSprocket.getSku()).isEqualTo(UPDATED_SKU);
        assertThat(testSprocket.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testSprocket.getAu()).isEqualTo(UPDATED_AU);
        assertThat(testSprocket.getDe()).isEqualTo(UPDATED_DE);
        assertThat(testSprocket.getMetalGearvisibility()).isEqualTo(UPDATED_METAL_GEARVISIBILITY);
        assertThat(testSprocket.getBikematevisibility()).isEqualTo(UPDATED_BIKEMATEVISIBILITY);
        assertThat(testSprocket.getMgiVisibility()).isEqualTo(UPDATED_MGI_VISIBILITY);
        assertThat(testSprocket.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testSprocket.getProductGroup1()).isEqualTo(UPDATED_PRODUCT_GROUP_1);
        assertThat(testSprocket.getProductGroup2()).isEqualTo(UPDATED_PRODUCT_GROUP_2);
        assertThat(testSprocket.getCountries()).isEqualTo(UPDATED_COUNTRIES);
        assertThat(testSprocket.getFitment()).isEqualTo(UPDATED_FITMENT);
        assertThat(testSprocket.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testSprocket.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testSprocket.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testSprocket.getBrand()).isEqualTo(UPDATED_BRAND);
        assertThat(testSprocket.getBiketypes()).isEqualTo(UPDATED_BIKETYPES);
        assertThat(testSprocket.getFitsMakes()).isEqualTo(UPDATED_FITS_MAKES);
        assertThat(testSprocket.getModelsupto()).isEqualTo(UPDATED_MODELSUPTO);
        assertThat(testSprocket.getgS1EAN()).isEqualTo(UPDATED_G_S_1_EAN);
        assertThat(testSprocket.getOurNotes()).isEqualTo(UPDATED_OUR_NOTES);
        assertThat(testSprocket.getCustomerNotes()).isEqualTo(UPDATED_CUSTOMER_NOTES);
        assertThat(testSprocket.getWeightkg()).isEqualTo(UPDATED_WEIGHTKG);
        assertThat(testSprocket.getPackType()).isEqualTo(UPDATED_PACK_TYPE);
        assertThat(testSprocket.getPackLength()).isEqualTo(UPDATED_PACK_LENGTH);
        assertThat(testSprocket.getPackWidth()).isEqualTo(UPDATED_PACK_WIDTH);
        assertThat(testSprocket.getPackHeight()).isEqualTo(UPDATED_PACK_HEIGHT);
        assertThat(testSprocket.getPackCubic()).isEqualTo(UPDATED_PACK_CUBIC);
        assertThat(testSprocket.getSprocketChainSize()).isEqualTo(UPDATED_SPROCKET_CHAIN_SIZE);
        assertThat(testSprocket.getSprocketTeeth()).isEqualTo(UPDATED_SPROCKET_TEETH);
        assertThat(testSprocket.geteSBHC()).isEqualTo(UPDATED_E_SBHC);
        assertThat(testSprocket.geteSID()).isEqualTo(UPDATED_E_SID);
        assertThat(testSprocket.geteSIDinnerTeeth()).isEqualTo(UPDATED_E_SI_DINNER_TEETH);
        assertThat(testSprocket.geteSBHQty()).isEqualTo(UPDATED_E_SBH_QTY);
        assertThat(testSprocket.geteSBHSize()).isEqualTo(UPDATED_E_SBH_SIZE);
        assertThat(testSprocket.geteSBHType()).isEqualTo(UPDATED_E_SBH_TYPE);
        assertThat(testSprocket.geteSWidth()).isEqualTo(UPDATED_E_S_WIDTH);
        assertThat(testSprocket.getTolistonEbay()).isEqualTo(UPDATED_TOLISTON_EBAY);
        assertThat(testSprocket.geteListing()).isEqualTo(UPDATED_E_LISTING);
        assertThat(testSprocket.getEforMake()).isEqualTo(UPDATED_EFOR_MAKE);
        assertThat(testSprocket.getEuploadedNeto()).isEqualTo(UPDATED_EUPLOADED_NETO);
        assertThat(testSprocket.geteDate()).isEqualTo(UPDATED_E_DATE);
        assertThat(testSprocket.getEcheck()).isEqualTo(UPDATED_ECHECK);
        assertThat(testSprocket.getEuploadedeBay()).isEqualTo(UPDATED_EUPLOADEDE_BAY);
        assertThat(testSprocket.geteBayactive()).isEqualTo(UPDATED_E_BAYACTIVE);
        assertThat(testSprocket.getePhotobucket()).isEqualTo(UPDATED_E_PHOTOBUCKET);
        assertThat(testSprocket.getePhotoMain()).isEqualTo(UPDATED_E_PHOTO_MAIN);
        assertThat(testSprocket.getePhotoClear()).isEqualTo(UPDATED_E_PHOTO_CLEAR);
        assertThat(testSprocket.getePhotoSide()).isEqualTo(UPDATED_E_PHOTO_SIDE);
        assertThat(testSprocket.getSalesStatus()).isEqualTo(UPDATED_SALES_STATUS);
        assertThat(testSprocket.getrRP()).isEqualTo(UPDATED_R_RP);
        assertThat(testSprocket.geteBay()).isEqualTo(UPDATED_E_BAY);
        assertThat(testSprocket.getTrade1()).isEqualTo(UPDATED_TRADE_1);
        assertThat(testSprocket.getTrade2()).isEqualTo(UPDATED_TRADE_2);
        assertThat(testSprocket.getTrade3()).isEqualTo(UPDATED_TRADE_3);
        assertThat(testSprocket.getDistributorNZAUD()).isEqualTo(UPDATED_DISTRIBUTOR_NZAUD);
        assertThat(testSprocket.getDistributorUSD()).isEqualTo(UPDATED_DISTRIBUTOR_USD);
        assertThat(testSprocket.getDistributorEUR()).isEqualTo(UPDATED_DISTRIBUTOR_EUR);
        assertThat(testSprocket.getBikemateAUD()).isEqualTo(UPDATED_BIKEMATE_AUD);
        assertThat(testSprocket.getCompMetalGear()).isEqualTo(UPDATED_COMP_METAL_GEAR);
        assertThat(testSprocket.getCompMogema()).isEqualTo(UPDATED_COMP_MOGEMA);
        assertThat(testSprocket.getCompJT()).isEqualTo(UPDATED_COMP_JT);
        assertThat(testSprocket.getjTBHC()).isEqualTo(UPDATED_J_TBHC);
        assertThat(testSprocket.getjTID()).isEqualTo(UPDATED_J_TID);
        assertThat(testSprocket.getjTIDinnerTeeth()).isEqualTo(UPDATED_J_TI_DINNER_TEETH);
        assertThat(testSprocket.getjTBHQty()).isEqualTo(UPDATED_J_TBH_QTY);
        assertThat(testSprocket.getjTBHSize()).isEqualTo(UPDATED_J_TBH_SIZE);
        assertThat(testSprocket.getjTBHType()).isEqualTo(UPDATED_J_TBH_TYPE);
        assertThat(testSprocket.getjTWidth()).isEqualTo(UPDATED_J_T_WIDTH);
        assertThat(testSprocket.getjTNote()).isEqualTo(UPDATED_J_T_NOTE);
        assertThat(testSprocket.getCompEsjot()).isEqualTo(UPDATED_COMP_ESJOT);
        assertThat(testSprocket.getCompSuperSprox()).isEqualTo(UPDATED_COMP_SUPER_SPROX);
        assertThat(testSprocket.getStock()).isEqualTo(UPDATED_STOCK);
        assertThat(testSprocket.getMinStock()).isEqualTo(UPDATED_MIN_STOCK);
        assertThat(testSprocket.getMaxStock()).isEqualTo(UPDATED_MAX_STOCK);
        assertThat(testSprocket.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testSprocket.getSupplierCode()).isEqualTo(UPDATED_SUPPLIER_CODE);
        assertThat(testSprocket.getSupplierCurrency()).isEqualTo(UPDATED_SUPPLIER_CURRENCY);
        assertThat(testSprocket.getSupplierCost()).isEqualTo(UPDATED_SUPPLIER_COST);
    }

    @Test
    @Transactional
    public void updateNonExistingSprocket() throws Exception {
        int databaseSizeBeforeUpdate = sprocketRepository.findAll().size();

        // Create the Sprocket
        SprocketDTO sprocketDTO = sprocketMapper.toDto(sprocket);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSprocketMockMvc.perform(put("/api/sprockets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sprocketDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Sprocket in the database
        List<Sprocket> sprocketList = sprocketRepository.findAll();
        assertThat(sprocketList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSprocket() throws Exception {
        // Initialize the database
        sprocketRepository.saveAndFlush(sprocket);

        int databaseSizeBeforeDelete = sprocketRepository.findAll().size();

        // Get the sprocket
        restSprocketMockMvc.perform(delete("/api/sprockets/{id}", sprocket.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Sprocket> sprocketList = sprocketRepository.findAll();
        assertThat(sprocketList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Sprocket.class);
        Sprocket sprocket1 = new Sprocket();
        sprocket1.setId(1L);
        Sprocket sprocket2 = new Sprocket();
        sprocket2.setId(sprocket1.getId());
        assertThat(sprocket1).isEqualTo(sprocket2);
        sprocket2.setId(2L);
        assertThat(sprocket1).isNotEqualTo(sprocket2);
        sprocket1.setId(null);
        assertThat(sprocket1).isNotEqualTo(sprocket2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SprocketDTO.class);
        SprocketDTO sprocketDTO1 = new SprocketDTO();
        sprocketDTO1.setId(1L);
        SprocketDTO sprocketDTO2 = new SprocketDTO();
        assertThat(sprocketDTO1).isNotEqualTo(sprocketDTO2);
        sprocketDTO2.setId(sprocketDTO1.getId());
        assertThat(sprocketDTO1).isEqualTo(sprocketDTO2);
        sprocketDTO2.setId(2L);
        assertThat(sprocketDTO1).isNotEqualTo(sprocketDTO2);
        sprocketDTO1.setId(null);
        assertThat(sprocketDTO1).isNotEqualTo(sprocketDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(sprocketMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(sprocketMapper.fromId(null)).isNull();
    }
}
