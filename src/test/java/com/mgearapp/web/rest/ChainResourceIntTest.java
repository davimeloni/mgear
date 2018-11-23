package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.Chain;
import com.mgearapp.repository.ChainRepository;
import com.mgearapp.service.ChainService;
import com.mgearapp.service.dto.ChainDTO;
import com.mgearapp.service.mapper.ChainMapper;
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
 * Test class for the ChainResource REST controller.
 *
 * @see ChainResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class ChainResourceIntTest {

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

    private static final BigDecimal DEFAULT_PACK_HEIGHT = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_HEIGHT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PACK_WIDTH = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_WIDTH = new BigDecimal(2);

    private static final Long DEFAULT_MAXCC_DIRT = 1L;
    private static final Long UPDATED_MAXCC_DIRT = 2L;

    private static final BigDecimal DEFAULT_PACK_CUBIC = new BigDecimal(1);
    private static final BigDecimal UPDATED_PACK_CUBIC = new BigDecimal(2);

    private static final Long DEFAULT_MAXCC_STREET = 1L;
    private static final Long UPDATED_MAXCC_STREET = 2L;

    private static final Long DEFAULT_CHAIN_SIZE = 1L;
    private static final Long UPDATED_CHAIN_SIZE = 2L;

    private static final String DEFAULT_CHAIN_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_TYPE = "BBBBBBBBBB";

    private static final Long DEFAULT_CHAIN_LINKS = 1L;
    private static final Long UPDATED_CHAIN_LINKS = 2L;

    private static final String DEFAULT_CHAIN_TENSILE_STRENGTH_N = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_TENSILE_STRENGTH_N = "BBBBBBBBBB";

    private static final String DEFAULT_CHAIN_COLOUR = "AAAAAAAAAA";
    private static final String UPDATED_CHAIN_COLOUR = "BBBBBBBBBB";

    private static final String DEFAULT_COMP_RK = "AAAAAAAAAA";
    private static final String UPDATED_COMP_RK = "BBBBBBBBBB";

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

    private static final Long DEFAULT_TOTAL_STOCK = 1L;
    private static final Long UPDATED_TOTAL_STOCK = 2L;

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
    private ChainRepository chainRepository;

    @Autowired
    private ChainMapper chainMapper;
    
    @Autowired
    private ChainService chainService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restChainMockMvc;

    private Chain chain;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ChainResource chainResource = new ChainResource(chainService);
        this.restChainMockMvc = MockMvcBuilders.standaloneSetup(chainResource)
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
    public static Chain createEntity(EntityManager em) {
        Chain chain = new Chain()
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
            .description(DEFAULT_DESCRIPTION)
            .unit(DEFAULT_UNIT)
            .qty(DEFAULT_QTY)
            .brand(DEFAULT_BRAND)
            .biketypes(DEFAULT_BIKETYPES)
            .gS1EAN(DEFAULT_G_S_1_EAN)
            .ourNotes(DEFAULT_OUR_NOTES)
            .customerNotes(DEFAULT_CUSTOMER_NOTES)
            .weightkg(DEFAULT_WEIGHTKG)
            .packType(DEFAULT_PACK_TYPE)
            .packLength(DEFAULT_PACK_LENGTH)
            .packHeight(DEFAULT_PACK_HEIGHT)
            .packWidth(DEFAULT_PACK_WIDTH)
            .maxccDirt(DEFAULT_MAXCC_DIRT)
            .packCubic(DEFAULT_PACK_CUBIC)
            .maxccStreet(DEFAULT_MAXCC_STREET)
            .chainSize(DEFAULT_CHAIN_SIZE)
            .chainType(DEFAULT_CHAIN_TYPE)
            .chainLinks(DEFAULT_CHAIN_LINKS)
            .chainTensileStrengthN(DEFAULT_CHAIN_TENSILE_STRENGTH_N)
            .chainColour(DEFAULT_CHAIN_COLOUR)
            .compRK(DEFAULT_COMP_RK)
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
            .totalStock(DEFAULT_TOTAL_STOCK)
            .minStock(DEFAULT_MIN_STOCK)
            .maxStock(DEFAULT_MAX_STOCK)
            .supplier(DEFAULT_SUPPLIER)
            .supplierCode(DEFAULT_SUPPLIER_CODE)
            .supplierCurrency(DEFAULT_SUPPLIER_CURRENCY)
            .supplierCost(DEFAULT_SUPPLIER_COST);
        return chain;
    }

    @Before
    public void initTest() {
        chain = createEntity(em);
    }

    @Test
    @Transactional
    public void createChain() throws Exception {
        int databaseSizeBeforeCreate = chainRepository.findAll().size();

        // Create the Chain
        ChainDTO chainDTO = chainMapper.toDto(chain);
        restChainMockMvc.perform(post("/api/chains")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(chainDTO)))
            .andExpect(status().isCreated());

        // Validate the Chain in the database
        List<Chain> chainList = chainRepository.findAll();
        assertThat(chainList).hasSize(databaseSizeBeforeCreate + 1);
        Chain testChain = chainList.get(chainList.size() - 1);
        assertThat(testChain.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(testChain.getActive()).isEqualTo(DEFAULT_ACTIVE);
        assertThat(testChain.getAu()).isEqualTo(DEFAULT_AU);
        assertThat(testChain.getDe()).isEqualTo(DEFAULT_DE);
        assertThat(testChain.getMetalGearvisibility()).isEqualTo(DEFAULT_METAL_GEARVISIBILITY);
        assertThat(testChain.getBikematevisibility()).isEqualTo(DEFAULT_BIKEMATEVISIBILITY);
        assertThat(testChain.getMgiVisibility()).isEqualTo(DEFAULT_MGI_VISIBILITY);
        assertThat(testChain.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testChain.getProductGroup1()).isEqualTo(DEFAULT_PRODUCT_GROUP_1);
        assertThat(testChain.getProductGroup2()).isEqualTo(DEFAULT_PRODUCT_GROUP_2);
        assertThat(testChain.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testChain.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testChain.getQty()).isEqualTo(DEFAULT_QTY);
        assertThat(testChain.getBrand()).isEqualTo(DEFAULT_BRAND);
        assertThat(testChain.getBiketypes()).isEqualTo(DEFAULT_BIKETYPES);
        assertThat(testChain.getgS1EAN()).isEqualTo(DEFAULT_G_S_1_EAN);
        assertThat(testChain.getOurNotes()).isEqualTo(DEFAULT_OUR_NOTES);
        assertThat(testChain.getCustomerNotes()).isEqualTo(DEFAULT_CUSTOMER_NOTES);
        assertThat(testChain.getWeightkg()).isEqualTo(DEFAULT_WEIGHTKG);
        assertThat(testChain.getPackType()).isEqualTo(DEFAULT_PACK_TYPE);
        assertThat(testChain.getPackLength()).isEqualTo(DEFAULT_PACK_LENGTH);
        assertThat(testChain.getPackHeight()).isEqualTo(DEFAULT_PACK_HEIGHT);
        assertThat(testChain.getPackWidth()).isEqualTo(DEFAULT_PACK_WIDTH);
        assertThat(testChain.getMaxccDirt()).isEqualTo(DEFAULT_MAXCC_DIRT);
        assertThat(testChain.getPackCubic()).isEqualTo(DEFAULT_PACK_CUBIC);
        assertThat(testChain.getMaxccStreet()).isEqualTo(DEFAULT_MAXCC_STREET);
        assertThat(testChain.getChainSize()).isEqualTo(DEFAULT_CHAIN_SIZE);
        assertThat(testChain.getChainType()).isEqualTo(DEFAULT_CHAIN_TYPE);
        assertThat(testChain.getChainLinks()).isEqualTo(DEFAULT_CHAIN_LINKS);
        assertThat(testChain.getChainTensileStrengthN()).isEqualTo(DEFAULT_CHAIN_TENSILE_STRENGTH_N);
        assertThat(testChain.getChainColour()).isEqualTo(DEFAULT_CHAIN_COLOUR);
        assertThat(testChain.getCompRK()).isEqualTo(DEFAULT_COMP_RK);
        assertThat(testChain.geteListing()).isEqualTo(DEFAULT_E_LISTING);
        assertThat(testChain.getEforMake()).isEqualTo(DEFAULT_EFOR_MAKE);
        assertThat(testChain.getEuploadedNeto()).isEqualTo(DEFAULT_EUPLOADED_NETO);
        assertThat(testChain.geteDate()).isEqualTo(DEFAULT_E_DATE);
        assertThat(testChain.getEcheck()).isEqualTo(DEFAULT_ECHECK);
        assertThat(testChain.getEuploadedeBay()).isEqualTo(DEFAULT_EUPLOADEDE_BAY);
        assertThat(testChain.geteBayactive()).isEqualTo(DEFAULT_E_BAYACTIVE);
        assertThat(testChain.getePhotobucket()).isEqualTo(DEFAULT_E_PHOTOBUCKET);
        assertThat(testChain.getePhotoMain()).isEqualTo(DEFAULT_E_PHOTO_MAIN);
        assertThat(testChain.getePhotoClear()).isEqualTo(DEFAULT_E_PHOTO_CLEAR);
        assertThat(testChain.getePhotoSide()).isEqualTo(DEFAULT_E_PHOTO_SIDE);
        assertThat(testChain.getSalesStatus()).isEqualTo(DEFAULT_SALES_STATUS);
        assertThat(testChain.getrRP()).isEqualTo(DEFAULT_R_RP);
        assertThat(testChain.geteBay()).isEqualTo(DEFAULT_E_BAY);
        assertThat(testChain.getTrade1()).isEqualTo(DEFAULT_TRADE_1);
        assertThat(testChain.getTrade2()).isEqualTo(DEFAULT_TRADE_2);
        assertThat(testChain.getTrade3()).isEqualTo(DEFAULT_TRADE_3);
        assertThat(testChain.getDistributorNZAUD()).isEqualTo(DEFAULT_DISTRIBUTOR_NZAUD);
        assertThat(testChain.getDistributorUSD()).isEqualTo(DEFAULT_DISTRIBUTOR_USD);
        assertThat(testChain.getDistributorEUR()).isEqualTo(DEFAULT_DISTRIBUTOR_EUR);
        assertThat(testChain.getTotalStock()).isEqualTo(DEFAULT_TOTAL_STOCK);
        assertThat(testChain.getMinStock()).isEqualTo(DEFAULT_MIN_STOCK);
        assertThat(testChain.getMaxStock()).isEqualTo(DEFAULT_MAX_STOCK);
        assertThat(testChain.getSupplier()).isEqualTo(DEFAULT_SUPPLIER);
        assertThat(testChain.getSupplierCode()).isEqualTo(DEFAULT_SUPPLIER_CODE);
        assertThat(testChain.getSupplierCurrency()).isEqualTo(DEFAULT_SUPPLIER_CURRENCY);
        assertThat(testChain.getSupplierCost()).isEqualTo(DEFAULT_SUPPLIER_COST);
    }

    @Test
    @Transactional
    public void createChainWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = chainRepository.findAll().size();

        // Create the Chain with an existing ID
        chain.setId(1L);
        ChainDTO chainDTO = chainMapper.toDto(chain);

        // An entity with an existing ID cannot be created, so this API call must fail
        restChainMockMvc.perform(post("/api/chains")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(chainDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Chain in the database
        List<Chain> chainList = chainRepository.findAll();
        assertThat(chainList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllChains() throws Exception {
        // Initialize the database
        chainRepository.saveAndFlush(chain);

        // Get all the chainList
        restChainMockMvc.perform(get("/api/chains?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(chain.getId().intValue())))
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
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.toString())))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY.intValue())))
            .andExpect(jsonPath("$.[*].brand").value(hasItem(DEFAULT_BRAND.toString())))
            .andExpect(jsonPath("$.[*].biketypes").value(hasItem(DEFAULT_BIKETYPES.toString())))
            .andExpect(jsonPath("$.[*].gS1EAN").value(hasItem(DEFAULT_G_S_1_EAN.intValue())))
            .andExpect(jsonPath("$.[*].ourNotes").value(hasItem(DEFAULT_OUR_NOTES.toString())))
            .andExpect(jsonPath("$.[*].customerNotes").value(hasItem(DEFAULT_CUSTOMER_NOTES.toString())))
            .andExpect(jsonPath("$.[*].weightkg").value(hasItem(DEFAULT_WEIGHTKG.intValue())))
            .andExpect(jsonPath("$.[*].packType").value(hasItem(DEFAULT_PACK_TYPE.toString())))
            .andExpect(jsonPath("$.[*].packLength").value(hasItem(DEFAULT_PACK_LENGTH.intValue())))
            .andExpect(jsonPath("$.[*].packHeight").value(hasItem(DEFAULT_PACK_HEIGHT.intValue())))
            .andExpect(jsonPath("$.[*].packWidth").value(hasItem(DEFAULT_PACK_WIDTH.intValue())))
            .andExpect(jsonPath("$.[*].maxccDirt").value(hasItem(DEFAULT_MAXCC_DIRT.intValue())))
            .andExpect(jsonPath("$.[*].packCubic").value(hasItem(DEFAULT_PACK_CUBIC.intValue())))
            .andExpect(jsonPath("$.[*].maxccStreet").value(hasItem(DEFAULT_MAXCC_STREET.intValue())))
            .andExpect(jsonPath("$.[*].chainSize").value(hasItem(DEFAULT_CHAIN_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].chainType").value(hasItem(DEFAULT_CHAIN_TYPE.toString())))
            .andExpect(jsonPath("$.[*].chainLinks").value(hasItem(DEFAULT_CHAIN_LINKS.intValue())))
            .andExpect(jsonPath("$.[*].chainTensileStrengthN").value(hasItem(DEFAULT_CHAIN_TENSILE_STRENGTH_N.toString())))
            .andExpect(jsonPath("$.[*].chainColour").value(hasItem(DEFAULT_CHAIN_COLOUR.toString())))
            .andExpect(jsonPath("$.[*].compRK").value(hasItem(DEFAULT_COMP_RK.toString())))
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
            .andExpect(jsonPath("$.[*].totalStock").value(hasItem(DEFAULT_TOTAL_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].minStock").value(hasItem(DEFAULT_MIN_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].maxStock").value(hasItem(DEFAULT_MAX_STOCK.intValue())))
            .andExpect(jsonPath("$.[*].supplier").value(hasItem(DEFAULT_SUPPLIER.toString())))
            .andExpect(jsonPath("$.[*].supplierCode").value(hasItem(DEFAULT_SUPPLIER_CODE.toString())))
            .andExpect(jsonPath("$.[*].supplierCurrency").value(hasItem(DEFAULT_SUPPLIER_CURRENCY.toString())))
            .andExpect(jsonPath("$.[*].supplierCost").value(hasItem(DEFAULT_SUPPLIER_COST.intValue())));
    }
    
    @Test
    @Transactional
    public void getChain() throws Exception {
        // Initialize the database
        chainRepository.saveAndFlush(chain);

        // Get the chain
        restChainMockMvc.perform(get("/api/chains/{id}", chain.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(chain.getId().intValue()))
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
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.toString()))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY.intValue()))
            .andExpect(jsonPath("$.brand").value(DEFAULT_BRAND.toString()))
            .andExpect(jsonPath("$.biketypes").value(DEFAULT_BIKETYPES.toString()))
            .andExpect(jsonPath("$.gS1EAN").value(DEFAULT_G_S_1_EAN.intValue()))
            .andExpect(jsonPath("$.ourNotes").value(DEFAULT_OUR_NOTES.toString()))
            .andExpect(jsonPath("$.customerNotes").value(DEFAULT_CUSTOMER_NOTES.toString()))
            .andExpect(jsonPath("$.weightkg").value(DEFAULT_WEIGHTKG.intValue()))
            .andExpect(jsonPath("$.packType").value(DEFAULT_PACK_TYPE.toString()))
            .andExpect(jsonPath("$.packLength").value(DEFAULT_PACK_LENGTH.intValue()))
            .andExpect(jsonPath("$.packHeight").value(DEFAULT_PACK_HEIGHT.intValue()))
            .andExpect(jsonPath("$.packWidth").value(DEFAULT_PACK_WIDTH.intValue()))
            .andExpect(jsonPath("$.maxccDirt").value(DEFAULT_MAXCC_DIRT.intValue()))
            .andExpect(jsonPath("$.packCubic").value(DEFAULT_PACK_CUBIC.intValue()))
            .andExpect(jsonPath("$.maxccStreet").value(DEFAULT_MAXCC_STREET.intValue()))
            .andExpect(jsonPath("$.chainSize").value(DEFAULT_CHAIN_SIZE.intValue()))
            .andExpect(jsonPath("$.chainType").value(DEFAULT_CHAIN_TYPE.toString()))
            .andExpect(jsonPath("$.chainLinks").value(DEFAULT_CHAIN_LINKS.intValue()))
            .andExpect(jsonPath("$.chainTensileStrengthN").value(DEFAULT_CHAIN_TENSILE_STRENGTH_N.toString()))
            .andExpect(jsonPath("$.chainColour").value(DEFAULT_CHAIN_COLOUR.toString()))
            .andExpect(jsonPath("$.compRK").value(DEFAULT_COMP_RK.toString()))
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
            .andExpect(jsonPath("$.totalStock").value(DEFAULT_TOTAL_STOCK.intValue()))
            .andExpect(jsonPath("$.minStock").value(DEFAULT_MIN_STOCK.intValue()))
            .andExpect(jsonPath("$.maxStock").value(DEFAULT_MAX_STOCK.intValue()))
            .andExpect(jsonPath("$.supplier").value(DEFAULT_SUPPLIER.toString()))
            .andExpect(jsonPath("$.supplierCode").value(DEFAULT_SUPPLIER_CODE.toString()))
            .andExpect(jsonPath("$.supplierCurrency").value(DEFAULT_SUPPLIER_CURRENCY.toString()))
            .andExpect(jsonPath("$.supplierCost").value(DEFAULT_SUPPLIER_COST.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingChain() throws Exception {
        // Get the chain
        restChainMockMvc.perform(get("/api/chains/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateChain() throws Exception {
        // Initialize the database
        chainRepository.saveAndFlush(chain);

        int databaseSizeBeforeUpdate = chainRepository.findAll().size();

        // Update the chain
        Chain updatedChain = chainRepository.findById(chain.getId()).get();
        // Disconnect from session so that the updates on updatedChain are not directly saved in db
        em.detach(updatedChain);
        updatedChain
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
            .description(UPDATED_DESCRIPTION)
            .unit(UPDATED_UNIT)
            .qty(UPDATED_QTY)
            .brand(UPDATED_BRAND)
            .biketypes(UPDATED_BIKETYPES)
            .gS1EAN(UPDATED_G_S_1_EAN)
            .ourNotes(UPDATED_OUR_NOTES)
            .customerNotes(UPDATED_CUSTOMER_NOTES)
            .weightkg(UPDATED_WEIGHTKG)
            .packType(UPDATED_PACK_TYPE)
            .packLength(UPDATED_PACK_LENGTH)
            .packHeight(UPDATED_PACK_HEIGHT)
            .packWidth(UPDATED_PACK_WIDTH)
            .maxccDirt(UPDATED_MAXCC_DIRT)
            .packCubic(UPDATED_PACK_CUBIC)
            .maxccStreet(UPDATED_MAXCC_STREET)
            .chainSize(UPDATED_CHAIN_SIZE)
            .chainType(UPDATED_CHAIN_TYPE)
            .chainLinks(UPDATED_CHAIN_LINKS)
            .chainTensileStrengthN(UPDATED_CHAIN_TENSILE_STRENGTH_N)
            .chainColour(UPDATED_CHAIN_COLOUR)
            .compRK(UPDATED_COMP_RK)
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
            .totalStock(UPDATED_TOTAL_STOCK)
            .minStock(UPDATED_MIN_STOCK)
            .maxStock(UPDATED_MAX_STOCK)
            .supplier(UPDATED_SUPPLIER)
            .supplierCode(UPDATED_SUPPLIER_CODE)
            .supplierCurrency(UPDATED_SUPPLIER_CURRENCY)
            .supplierCost(UPDATED_SUPPLIER_COST);
        ChainDTO chainDTO = chainMapper.toDto(updatedChain);

        restChainMockMvc.perform(put("/api/chains")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(chainDTO)))
            .andExpect(status().isOk());

        // Validate the Chain in the database
        List<Chain> chainList = chainRepository.findAll();
        assertThat(chainList).hasSize(databaseSizeBeforeUpdate);
        Chain testChain = chainList.get(chainList.size() - 1);
        assertThat(testChain.getSku()).isEqualTo(UPDATED_SKU);
        assertThat(testChain.getActive()).isEqualTo(UPDATED_ACTIVE);
        assertThat(testChain.getAu()).isEqualTo(UPDATED_AU);
        assertThat(testChain.getDe()).isEqualTo(UPDATED_DE);
        assertThat(testChain.getMetalGearvisibility()).isEqualTo(UPDATED_METAL_GEARVISIBILITY);
        assertThat(testChain.getBikematevisibility()).isEqualTo(UPDATED_BIKEMATEVISIBILITY);
        assertThat(testChain.getMgiVisibility()).isEqualTo(UPDATED_MGI_VISIBILITY);
        assertThat(testChain.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testChain.getProductGroup1()).isEqualTo(UPDATED_PRODUCT_GROUP_1);
        assertThat(testChain.getProductGroup2()).isEqualTo(UPDATED_PRODUCT_GROUP_2);
        assertThat(testChain.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testChain.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testChain.getQty()).isEqualTo(UPDATED_QTY);
        assertThat(testChain.getBrand()).isEqualTo(UPDATED_BRAND);
        assertThat(testChain.getBiketypes()).isEqualTo(UPDATED_BIKETYPES);
        assertThat(testChain.getgS1EAN()).isEqualTo(UPDATED_G_S_1_EAN);
        assertThat(testChain.getOurNotes()).isEqualTo(UPDATED_OUR_NOTES);
        assertThat(testChain.getCustomerNotes()).isEqualTo(UPDATED_CUSTOMER_NOTES);
        assertThat(testChain.getWeightkg()).isEqualTo(UPDATED_WEIGHTKG);
        assertThat(testChain.getPackType()).isEqualTo(UPDATED_PACK_TYPE);
        assertThat(testChain.getPackLength()).isEqualTo(UPDATED_PACK_LENGTH);
        assertThat(testChain.getPackHeight()).isEqualTo(UPDATED_PACK_HEIGHT);
        assertThat(testChain.getPackWidth()).isEqualTo(UPDATED_PACK_WIDTH);
        assertThat(testChain.getMaxccDirt()).isEqualTo(UPDATED_MAXCC_DIRT);
        assertThat(testChain.getPackCubic()).isEqualTo(UPDATED_PACK_CUBIC);
        assertThat(testChain.getMaxccStreet()).isEqualTo(UPDATED_MAXCC_STREET);
        assertThat(testChain.getChainSize()).isEqualTo(UPDATED_CHAIN_SIZE);
        assertThat(testChain.getChainType()).isEqualTo(UPDATED_CHAIN_TYPE);
        assertThat(testChain.getChainLinks()).isEqualTo(UPDATED_CHAIN_LINKS);
        assertThat(testChain.getChainTensileStrengthN()).isEqualTo(UPDATED_CHAIN_TENSILE_STRENGTH_N);
        assertThat(testChain.getChainColour()).isEqualTo(UPDATED_CHAIN_COLOUR);
        assertThat(testChain.getCompRK()).isEqualTo(UPDATED_COMP_RK);
        assertThat(testChain.geteListing()).isEqualTo(UPDATED_E_LISTING);
        assertThat(testChain.getEforMake()).isEqualTo(UPDATED_EFOR_MAKE);
        assertThat(testChain.getEuploadedNeto()).isEqualTo(UPDATED_EUPLOADED_NETO);
        assertThat(testChain.geteDate()).isEqualTo(UPDATED_E_DATE);
        assertThat(testChain.getEcheck()).isEqualTo(UPDATED_ECHECK);
        assertThat(testChain.getEuploadedeBay()).isEqualTo(UPDATED_EUPLOADEDE_BAY);
        assertThat(testChain.geteBayactive()).isEqualTo(UPDATED_E_BAYACTIVE);
        assertThat(testChain.getePhotobucket()).isEqualTo(UPDATED_E_PHOTOBUCKET);
        assertThat(testChain.getePhotoMain()).isEqualTo(UPDATED_E_PHOTO_MAIN);
        assertThat(testChain.getePhotoClear()).isEqualTo(UPDATED_E_PHOTO_CLEAR);
        assertThat(testChain.getePhotoSide()).isEqualTo(UPDATED_E_PHOTO_SIDE);
        assertThat(testChain.getSalesStatus()).isEqualTo(UPDATED_SALES_STATUS);
        assertThat(testChain.getrRP()).isEqualTo(UPDATED_R_RP);
        assertThat(testChain.geteBay()).isEqualTo(UPDATED_E_BAY);
        assertThat(testChain.getTrade1()).isEqualTo(UPDATED_TRADE_1);
        assertThat(testChain.getTrade2()).isEqualTo(UPDATED_TRADE_2);
        assertThat(testChain.getTrade3()).isEqualTo(UPDATED_TRADE_3);
        assertThat(testChain.getDistributorNZAUD()).isEqualTo(UPDATED_DISTRIBUTOR_NZAUD);
        assertThat(testChain.getDistributorUSD()).isEqualTo(UPDATED_DISTRIBUTOR_USD);
        assertThat(testChain.getDistributorEUR()).isEqualTo(UPDATED_DISTRIBUTOR_EUR);
        assertThat(testChain.getTotalStock()).isEqualTo(UPDATED_TOTAL_STOCK);
        assertThat(testChain.getMinStock()).isEqualTo(UPDATED_MIN_STOCK);
        assertThat(testChain.getMaxStock()).isEqualTo(UPDATED_MAX_STOCK);
        assertThat(testChain.getSupplier()).isEqualTo(UPDATED_SUPPLIER);
        assertThat(testChain.getSupplierCode()).isEqualTo(UPDATED_SUPPLIER_CODE);
        assertThat(testChain.getSupplierCurrency()).isEqualTo(UPDATED_SUPPLIER_CURRENCY);
        assertThat(testChain.getSupplierCost()).isEqualTo(UPDATED_SUPPLIER_COST);
    }

    @Test
    @Transactional
    public void updateNonExistingChain() throws Exception {
        int databaseSizeBeforeUpdate = chainRepository.findAll().size();

        // Create the Chain
        ChainDTO chainDTO = chainMapper.toDto(chain);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restChainMockMvc.perform(put("/api/chains")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(chainDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Chain in the database
        List<Chain> chainList = chainRepository.findAll();
        assertThat(chainList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteChain() throws Exception {
        // Initialize the database
        chainRepository.saveAndFlush(chain);

        int databaseSizeBeforeDelete = chainRepository.findAll().size();

        // Get the chain
        restChainMockMvc.perform(delete("/api/chains/{id}", chain.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Chain> chainList = chainRepository.findAll();
        assertThat(chainList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Chain.class);
        Chain chain1 = new Chain();
        chain1.setId(1L);
        Chain chain2 = new Chain();
        chain2.setId(chain1.getId());
        assertThat(chain1).isEqualTo(chain2);
        chain2.setId(2L);
        assertThat(chain1).isNotEqualTo(chain2);
        chain1.setId(null);
        assertThat(chain1).isNotEqualTo(chain2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ChainDTO.class);
        ChainDTO chainDTO1 = new ChainDTO();
        chainDTO1.setId(1L);
        ChainDTO chainDTO2 = new ChainDTO();
        assertThat(chainDTO1).isNotEqualTo(chainDTO2);
        chainDTO2.setId(chainDTO1.getId());
        assertThat(chainDTO1).isEqualTo(chainDTO2);
        chainDTO2.setId(2L);
        assertThat(chainDTO1).isNotEqualTo(chainDTO2);
        chainDTO1.setId(null);
        assertThat(chainDTO1).isNotEqualTo(chainDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(chainMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(chainMapper.fromId(null)).isNull();
    }
}
