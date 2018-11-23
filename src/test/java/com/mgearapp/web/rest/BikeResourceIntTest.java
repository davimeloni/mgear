package com.mgearapp.web.rest;

import com.mgearapp.MgearappApp;

import com.mgearapp.domain.Bike;
import com.mgearapp.repository.BikeRepository;
import com.mgearapp.service.BikeService;
import com.mgearapp.service.dto.BikeDTO;
import com.mgearapp.service.mapper.BikeMapper;
import com.mgearapp.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import static com.mgearapp.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BikeResource REST controller.
 *
 * @see BikeResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MgearappApp.class)
public class BikeResourceIntTest {

    private static final String DEFAULT_VISIBILITY_AU = "AAAAAAAAAA";
    private static final String UPDATED_VISIBILITY_AU = "BBBBBBBBBB";

    private static final String DEFAULT_VISIBILITY_EU = "AAAAAAAAAA";
    private static final String UPDATED_VISIBILITY_EU = "BBBBBBBBBB";

    private static final String DEFAULT_INACTIVE = "AAAAAAAAAA";
    private static final String UPDATED_INACTIVE = "BBBBBBBBBB";

    private static final String DEFAULT_OEMCONFIRMED = "AAAAAAAAAA";
    private static final String UPDATED_OEMCONFIRMED = "BBBBBBBBBB";

    private static final String DEFAULT_OESOURCE = "AAAAAAAAAA";
    private static final String UPDATED_OESOURCE = "BBBBBBBBBB";

    private static final Long DEFAULT_EPID = 1L;
    private static final Long UPDATED_EPID = 2L;

    private static final String DEFAULT_MODELTYPE_1 = "AAAAAAAAAA";
    private static final String UPDATED_MODELTYPE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_MODELTYPE_2 = "AAAAAAAAAA";
    private static final String UPDATED_MODELTYPE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MANUFACTURER = "AAAAAAAAAA";
    private static final String UPDATED_MANUFACTURER = "BBBBBBBBBB";

    private static final String DEFAULT_STROKES = "AAAAAAAAAA";
    private static final String UPDATED_STROKES = "BBBBBBBBBB";

    private static final Long DEFAULT_CAPACITY = 1L;
    private static final Long UPDATED_CAPACITY = 2L;

    private static final String DEFAULT_MODEL_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_YEAR_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_YEAR_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_TYPE_CODE = "BBBBBBBBBB";

    private static final Long DEFAULT_YEAR = 1L;
    private static final Long UPDATED_YEAR = 2L;

    private static final String DEFAULT_FINAL_DRIVE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_FINAL_DRIVE_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CATEGORY_PATH = "AAAAAAAAAA";
    private static final String UPDATED_CATEGORY_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_NOTES_2 = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_NOTES_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_NOTES_3 = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_NOTES_3 = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_NOTES_4 = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_NOTES_4 = "BBBBBBBBBB";

    private static final String DEFAULT_MODEL_INFO_HTML = "AAAAAAAAAA";
    private static final String UPDATED_MODEL_INFO_HTML = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_SYSTEM_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_SYSTEM_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_DISC_LEFT = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_DISC_LEFT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_DISC_RIGHT = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_DISC_RIGHT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_DISC_BOLTS = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_DISC_BOLTS = "BBBBBBBBBB";

    private static final Long DEFAULT_OEM_FRONT_BDQTYPD = 1L;
    private static final Long UPDATED_OEM_FRONT_BDQTYPD = 2L;

    private static final String DEFAULT_OEM_FRONT_BRAKE_DISC_ABS_RING = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_DISC_ABS_RING = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_CALIPER_1 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_CALIPER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_CALIPER_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_CALIPER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_CALIPER_PIN = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_CALIPER_PIN = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_L = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_L = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_R = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_R = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_SHOE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_SHOE = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_MIDLDLE_AXLE_BRAKE_DISC = "AAAAAAAAAA";
    private static final String UPDATED_OEM_MIDLDLE_AXLE_BRAKE_DISC = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_MIDDLE_AXLE_BRAKE_PADS = "AAAAAAAAAA";
    private static final String UPDATED_OEM_MIDDLE_AXLE_BRAKE_PADS = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_BRAKE_SYSTEM_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_BRAKE_SYSTEM_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_OEAM_REAR_BRAKE_DISC = "AAAAAAAAAA";
    private static final String UPDATED_OEAM_REAR_BRAKE_DISC = "BBBBBBBBBB";

    private static final String DEFAULT_OEAM_REAR_BRAKE_DISC_BOLTS = "AAAAAAAAAA";
    private static final String UPDATED_OEAM_REAR_BRAKE_DISC_BOLTS = "BBBBBBBBBB";

    private static final Long DEFAULT_OEAM_REAR_BRAKE_DISC_BQTYPD = 1L;
    private static final Long UPDATED_OEAM_REAR_BRAKE_DISC_BQTYPD = 2L;

    private static final String DEFAULT_OEM_REAR_BRAKE_CALIPER = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_BRAKE_CALIPER = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_BRAKE_CALIPER_PIN = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_BRAKE_CALIPER_PIN = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_BRAKE_PADS_1 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_BRAKE_PADS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_BRAKE_PADS_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_BRAKE_PADS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_SHOE_REAR = "AAAAAAAAAA";
    private static final String UPDATED_OEM_SHOE_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_SHOE_REAR_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_SHOE_REAR_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_SLAVE_CYLINDER = "AAAAAAAAAA";
    private static final String UPDATED_OEM_SLAVE_CYLINDER = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_CHAIN_NO = "AAAAAAAAAA";
    private static final String UPDATED_OEM_CHAIN_NO = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_OEM_CHAIN_SIZE = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_CHAIN_SIZE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OEM_CHAIN_LINKS = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_CHAIN_LINKS = new BigDecimal(2);

    private static final String DEFAULT_OEM_FRONT_SPROCKET = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_SPROCKET = "BBBBBBBBBB";

    private static final Long DEFAULT_OEM_FRONT_GEARING = 1L;
    private static final Long UPDATED_OEM_FRONT_GEARING = 2L;

    private static final BigDecimal DEFAULT_OEM_FRONT_GEARING_MIN = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_FRONT_GEARING_MIN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OEM_FRONT_GEARING_MAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_FRONT_GEARING_MAX = new BigDecimal(2);

    private static final String DEFAULT_OEM_REAR_SPROCKET = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_SPROCKET = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_OEM_REAR_GEARING = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_REAR_GEARING = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OEM_REAR_GEARING_MIN = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_REAR_GEARING_MIN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_OEM_REAR_GEARING_MAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_REAR_GEARING_MAX = new BigDecimal(2);

    private static final String DEFAULT_FINAL_DRIVE_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_FINAL_DRIVE_NOTES = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_CHAIN_CONV_SIZE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CHAIN_CONV_SIZE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CHAIN_CONV_LINKS = new BigDecimal(1);
    private static final BigDecimal UPDATED_CHAIN_CONV_LINKS = new BigDecimal(2);

    private static final String DEFAULT_OEM_FRONT_WHEEL = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEEL = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_WHEEL_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEEL_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_OEM_FRONT_WHEEL_FRONT = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_FRONT_WHEEL_FRONT = new BigDecimal(2);

    private static final String DEFAULT_OEM_FRONT_WHEEL_TYRE_SIZE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEEL_TYRE_SIZE = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_HUB = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_HUB = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_WHEELBEARING_1 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEELBEARING_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_WHEELBEARING_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEELBEARING_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FRONT_WHEEL_SEAL = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FRONT_WHEEL_SEAL = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_WHEEL = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_WHEEL = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_OEM_REAR_WHEEL_SIZE = new BigDecimal(1);
    private static final BigDecimal UPDATED_OEM_REAR_WHEEL_SIZE = new BigDecimal(2);

    private static final String DEFAULT_OEM_REAR_WHEEL_TYRE = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_WHEEL_TYRE = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_WHEEL_BEARING_1 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_WHEEL_BEARING_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_WHEEL_BEARING_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_WHEEL_BEARING_2 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_REAR_WHEEL_SEAL = "AAAAAAAAAA";
    private static final String UPDATED_OEM_REAR_WHEEL_SEAL = "BBBBBBBBBB";

    private static final String DEFAULT_FRONT_PADS_DIFF_CALIPER = "AAAAAAAAAA";
    private static final String UPDATED_FRONT_PADS_DIFF_CALIPER = "BBBBBBBBBB";

    private static final Long DEFAULT_QTY_BH = 1L;
    private static final Long UPDATED_QTY_BH = 2L;

    private static final String DEFAULT_HANDBRAKE_PARKING = "AAAAAAAAAA";
    private static final String UPDATED_HANDBRAKE_PARKING = "BBBBBBBBBB";

    private static final String DEFAULT_ADD_NOTES_TO_BIKE = "AAAAAAAAAA";
    private static final String UPDATED_ADD_NOTES_TO_BIKE = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_AND_ID = "AAAAAAAAAA";
    private static final String UPDATED_DATE_AND_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_TUV_REQUIRED = "AAAAAAAAAA";
    private static final String UPDATED_TUV_REQUIRED = "BBBBBBBBBB";

    private static final String DEFAULT_TUV_TYPE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_TUV_TYPE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ABEKBA = "AAAAAAAAAA";
    private static final String UPDATED_ABEKBA = "BBBBBBBBBB";

    private static final String DEFAULT_TUV_FRONT_DISC = "AAAAAAAAAA";
    private static final String UPDATED_TUV_FRONT_DISC = "BBBBBBBBBB";

    private static final String DEFAULT_TUV_REAR_DISC = "AAAAAAAAAA";
    private static final String UPDATED_TUV_REAR_DISC = "BBBBBBBBBB";

    private static final String DEFAULT_BREMBO_BRAKE_DISC_FRONT_REF = "AAAAAAAAAA";
    private static final String UPDATED_BREMBO_BRAKE_DISC_FRONT_REF = "BBBBBBBBBB";

    private static final String DEFAULT_EBC_BRAKE_DISC_FRONT_REF = "AAAAAAAAAA";
    private static final String UPDATED_EBC_BRAKE_DISC_FRONT_REF = "BBBBBBBBBB";

    private static final String DEFAULT_TRW_BRAKE_DISC_FRONT_REF = "AAAAAAAAAA";
    private static final String UPDATED_TRW_BRAKE_DISC_FRONT_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_FRONT_CHECK = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_FRONT_CHECK = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2 = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2 = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_F_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_F_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_MOTODISC_BRAKE_DISC_F_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MOTODISC_BRAKE_DISC_F_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_EBC_BRAKE_PADS_FRONT_L_REF = "AAAAAAAAAA";
    private static final String UPDATED_EBC_BRAKE_PADS_FRONT_L_REF = "BBBBBBBBBB";

    private static final String DEFAULT_EBC_BRAKE_PADS_FRONT_R_REF = "AAAAAAAAAA";
    private static final String UPDATED_EBC_BRAKE_PADS_FRONT_R_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_FRONT_L_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_FRONT_L_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_FRONT_R_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_FRONT_R_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_F_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_F_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_L_REF = "AAAAAAAAAA";
    private static final String UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_L_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_R_REF = "AAAAAAAAAA";
    private static final String UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_R_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MOTOPAD_BRAKE_PADS_F_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MOTOPAD_BRAKE_PADS_F_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FC_REBUILD_KIT_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FC_REBUILD_KIT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FC_PIN = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FC_PIN = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FM_CY_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FM_CY_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FSC_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FSC_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_NEWFREN_SHOE_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_NEWFREN_SHOE_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2 = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2 = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_PARK_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_PARK_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_PARK_REF_2 = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_PARK_REF_2 = "BBBBBBBBBB";

    private static final String DEFAULT_EBC_BRAKE_DISC_REAR_REF = "AAAAAAAAAA";
    private static final String UPDATED_EBC_BRAKE_DISC_REAR_REF = "BBBBBBBBBB";

    private static final String DEFAULT_BREMBO_BRAKE_DISC_REAR_REF = "AAAAAAAAAA";
    private static final String UPDATED_BREMBO_BRAKE_DISC_REAR_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_REAR_REF = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_REAR_REF = "BBBBBBBBBB";

    private static final String DEFAULT_TRW_BRAKE_DISC_REAR_REF = "AAAAAAAAAA";
    private static final String UPDATED_TRW_BRAKE_DISC_REAR_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_DISC_REAR = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_DISC_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_RC_REBUILD_KIT_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_RC_REBUILD_KIT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_REAR_CALIPER_BOLT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_REAR_CALIPER_BOLT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_RM_CR_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_RM_CR_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_EBC_BRAKE_PADS_REAR_REF = "AAAAAAAAAA";
    private static final String UPDATED_EBC_BRAKE_PADS_REAR_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_BRAKE_PADS_REAR_NETO = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_BRAKE_PADS_REAR_NETO = "BBBBBBBBBB";

    private static final String DEFAULT_NEWFREN_SHOE_REAR = "AAAAAAAAAA";
    private static final String UPDATED_NEWFREN_SHOE_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_REAR_BRAKE_PEDAL_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_REAR_BRAKE_PEDAL_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CSC_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CSC_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_FRONT_JT_REF_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_FRONT_JT_REF_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_ESJOT_REF_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_ESJOT_REF_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_REF_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_REF_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_MOGEMA_REF_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_MOGEMA_REF_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_SUPERSPROX_REF_FRONT = "AAAAAAAAAA";
    private static final String UPDATED_SUPERSPROX_REF_FRONT = "BBBBBBBBBB";

    private static final String DEFAULT_ESJOT_REF_REAR = "AAAAAAAAAA";
    private static final String UPDATED_ESJOT_REF_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_JT_REF_REAR = "AAAAAAAAAA";
    private static final String UPDATED_JT_REF_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_REF_REAR = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_REF_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_MOGEMA_REF_REAR = "AAAAAAAAAA";
    private static final String UPDATED_MOGEMA_REF_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_SUPERSPROX_REF_REAR = "AAAAAAAAAA";
    private static final String UPDATED_SUPERSPROX_REF_REAR = "BBBBBBBBBB";

    private static final String DEFAULT_ESJOT_REF_FRONT_CONV = "AAAAAAAAAA";
    private static final String UPDATED_ESJOT_REF_FRONT_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_JT_SPROCKET_REF = "AAAAAAAAAA";
    private static final String UPDATED_JT_SPROCKET_REF = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_REF_FRONT_CONV = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_REF_FRONT_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_MOGEMAREF_FRONT_CONV = "AAAAAAAAAA";
    private static final String UPDATED_MOGEMAREF_FRONT_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_SUPERSPROX_REF_FRONT_CONV = "AAAAAAAAAA";
    private static final String UPDATED_SUPERSPROX_REF_FRONT_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_CONVERSION_CHAIN = "AAAAAAAAAA";
    private static final String UPDATED_CONVERSION_CHAIN = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_SPROCKET_REAR_CONV = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_SPROCKET_REAR_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_ESJOT_REF_REAR_CONV = "AAAAAAAAAA";
    private static final String UPDATED_ESJOT_REF_REAR_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_MGEAR_REF_REAR_CONV = "AAAAAAAAAA";
    private static final String UPDATED_MGEAR_REF_REAR_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_MOGEMA_REF_REAR_CONV = "AAAAAAAAAA";
    private static final String UPDATED_MOGEMA_REF_REAR_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_SUPERSPROX_REF_REAR_CONV = "AAAAAAAAAA";
    private static final String UPDATED_SUPERSPROX_REF_REAR_CONV = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FW_BEARING_KIT_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FW_BEARING_KIT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FW_BEARING_KIT_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FW_BEARING_KIT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_RW_BEARING_KIT_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_RW_BEARING_KIT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_RW_BEARING_KIT_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_RW_BEARING_KIT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_RW_BEARING_UPGRADE = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_RW_BEARING_UPGRADE = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_SPARK_PLUG = "AAAAAAAAAA";
    private static final String UPDATED_OEM_SPARK_PLUG = "BBBBBBBBBB";

    private static final Long DEFAULT_OEM_SPARK_PLUG_QTY = 1L;
    private static final Long UPDATED_OEM_SPARK_PLUG_QTY = 2L;

    private static final String DEFAULT_NGK_SPARK_PLUG_SK_US = "AAAAAAAAAA";
    private static final String UPDATED_NGK_SPARK_PLUG_SK_US = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_ALTERNATOR = "AAAAAAAAAA";
    private static final String UPDATED_OEM_ALTERNATOR = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_VOLTAGE_REGULATOR = "AAAAAAAAAA";
    private static final String UPDATED_OEM_VOLTAGE_REGULATOR = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_ALTERNATOR = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_ALTERNATOR = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_ALTERNATOR_2 = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_ALTERNATOR_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_CDI_MODULE = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_CDI_MODULE = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_CHARGING_COIL = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_CHARGING_COIL = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_IGNITION_COIL = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_IGNITION_COIL = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_STATOR_COIL = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_STATOR_COIL = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_VOLTAGE_REGULATOR = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_VOLTAGE_REGULATOR = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_POWER_SHIFT_CM = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_POWER_SHIFT_CM = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_STARTER_DRIVE = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_STARTER_DRIVE = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_STARTER_MOTOR = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_STARTER_MOTOR = "BBBBBBBBBB";

    private static final String DEFAULT_ARROWHEAD_STARTER_RELAY = "AAAAAAAAAA";
    private static final String UPDATED_ARROWHEAD_STARTER_RELAY = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_BATTERY = "AAAAAAAAAA";
    private static final String UPDATED_OEM_BATTERY = "BBBBBBBBBB";

    private static final String DEFAULT_SSB_AGM_BATTERY = "AAAAAAAAAA";
    private static final String UPDATED_SSB_AGM_BATTERY = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_AIR_FILTER = "AAAAAAAAAA";
    private static final String UPDATED_OEM_AIR_FILTER = "BBBBBBBBBB";

    private static final String DEFAULT_KN_AIR_FILTER = "AAAAAAAAAA";
    private static final String UPDATED_KN_AIR_FILTER = "BBBBBBBBBB";

    private static final String DEFAULT_MOTOREX_AIR_FILTER = "AAAAAAAAAA";
    private static final String UPDATED_MOTOREX_AIR_FILTER = "BBBBBBBBBB";

    private static final String DEFAULT_MOTOREX_AIR_FILTER_PREOILED = "AAAAAAAAAA";
    private static final String UPDATED_MOTOREX_AIR_FILTER_PREOILED = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_OIL_FILTER_1 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_OIL_FILTER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_KN_OIL_FILTER_1 = "AAAAAAAAAA";
    private static final String UPDATED_KN_OIL_FILTER_1 = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_OIL_FILTER_2 = "AAAAAAAAAA";
    private static final String UPDATED_OEM_OIL_FILTER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_KN_OIL_FILTER_2 = "AAAAAAAAAA";
    private static final String UPDATED_KN_OIL_FILTER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_MOTION_PRO_OIL_FILTER_MAGNET = "AAAAAAAAAA";
    private static final String UPDATED_MOTION_PRO_OIL_FILTER_MAGNET = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_STEERING_BEARING = "AAAAAAAAAA";
    private static final String UPDATED_OEM_STEERING_BEARING = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_STEERING_SEAL = "AAAAAAAAAA";
    private static final String UPDATED_OEM_STEERING_SEAL = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_SB_SEAL_KIT_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_SB_SEAL_KIT_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_SB_SEAL_KIT_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_SB_SEAL_KIT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CB_SEAL_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CB_SEAL_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FORK_ASSEMBLY_LEFT = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FORK_ASSEMBLY_LEFT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FORK_ASSEMBLY_RIGHT = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FORK_ASSEMBLY_RIGHT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_FORK_SEALS = "AAAAAAAAAA";
    private static final String UPDATED_OEM_FORK_SEALS = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FORK_SEALS = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FORK_SEALS = "BBBBBBBBBB";

    private static final String DEFAULT_XPR_FORK_SEALS = "AAAAAAAAAA";
    private static final String UPDATED_XPR_FORK_SEALS = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FORK_BUSHING_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FORK_BUSHING_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_MOTION_PRO_MICRO_FORK_BLEEDER = "AAAAAAAAAA";
    private static final String UPDATED_MOTION_PRO_MICRO_FORK_BLEEDER = "BBBBBBBBBB";

    private static final String DEFAULT_MOTION_PRO_CR_PRO_THOTTLE_KIT = "AAAAAAAAAA";
    private static final String UPDATED_MOTION_PRO_CR_PRO_THOTTLE_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_CABLE_SPEEDO = "AAAAAAAAAA";
    private static final String UPDATED_OEM_CABLE_SPEEDO = "BBBBBBBBBB";

    private static final String DEFAULT_MOTION_PRO_CABLE_SPEEDO = "AAAAAAAAAA";
    private static final String UPDATED_MOTION_PRO_CABLE_SPEEDO = "BBBBBBBBBB";

    private static final String DEFAULT_MOTION_PRO_CABLE_THROTTLE_TUBE = "AAAAAAAAAA";
    private static final String UPDATED_MOTION_PRO_CABLE_THROTTLE_TUBE = "BBBBBBBBBB";

    private static final String DEFAULT_CROSSPRO_RADIATOR_GUARD = "AAAAAAAAAA";
    private static final String UPDATED_CROSSPRO_RADIATOR_GUARD = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_CLUTCH_FIBRES = "AAAAAAAAAA";
    private static final String UPDATED_OEM_CLUTCH_FIBRES = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_CLUTCH_FIBRES_STEELS = "AAAAAAAAAA";
    private static final String UPDATED_OEM_CLUTCH_FIBRES_STEELS = "BBBBBBBBBB";

    private static final String DEFAULT_NEWFREN_CLUTCH_KIT = "AAAAAAAAAA";
    private static final String UPDATED_NEWFREN_CLUTCH_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_NEWFREN_CLUTCH_SPRING_KITS = "AAAAAAAAAA";
    private static final String UPDATED_NEWFREN_CLUTCH_SPRING_KITS = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CMC_REBUILT_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CMC_REBUILT_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_WISECO_FORGED_CLUTCH_BASKET = "AAAAAAAAAA";
    private static final String UPDATED_WISECO_FORGED_CLUTCH_BASKET = "BBBBBBBBBB";

    private static final String DEFAULT_WISECO_BOTTEM_END_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_WISECO_BOTTEM_END_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_WRENCH_RE_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_WRENCH_RE_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_CARB_ASSEMBLY = "AAAAAAAAAA";
    private static final String UPDATED_OEM_CARB_ASSEMBLY = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CARB_REPAIR_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CARB_REPAIR_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_1 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2 = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FUEL_STAR_FUEL_VALVE_KIT = "AAAAAAAAAA";
    private static final String UPDATED_FUEL_STAR_FUEL_VALVE_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_FUEL_STAR_FUEL_VALVE_KIT_2 = "AAAAAAAAAA";
    private static final String UPDATED_FUEL_STAR_FUEL_VALVE_KIT_2 = "BBBBBBBBBB";

    private static final String DEFAULT_FUEL_STAR_HOSE_CLAMP_KIT = "AAAAAAAAAA";
    private static final String UPDATED_FUEL_STAR_HOSE_CLAMP_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_RG_ENGINE_COVER_LHS = "AAAAAAAAAA";
    private static final String UPDATED_RG_ENGINE_COVER_LHS = "BBBBBBBBBB";

    private static final String DEFAULT_RG_TAIL_TIDY = "AAAAAAAAAA";
    private static final String UPDATED_RG_TAIL_TIDY = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_LB_SEAL_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_LB_SEAL_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_LRS_BEARING_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_LRS_BEARING_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_URS_BEARING_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_URS_BEARING_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_ULS_BEARING_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_ULS_BEARING_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_ALL_BALLS_SB_SEAL_KIT = "AAAAAAAAAA";
    private static final String UPDATED_ALL_BALLS_SB_SEAL_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_PIVOT_WORKS_ST_BEARING_KIT = "AAAAAAAAAA";
    private static final String UPDATED_PIVOT_WORKS_ST_BEARING_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_PIVOT_WORKS_S_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_PIVOT_WORKS_S_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_MP_FORK_SEAL_DRIVER = "AAAAAAAAAA";
    private static final String UPDATED_MP_FORK_SEAL_DRIVER = "BBBBBBBBBB";

    private static final String DEFAULT_MP_VALVE_SEAL_INSTALL_TOOL = "AAAAAAAAAA";
    private static final String UPDATED_MP_VALVE_SEAL_INSTALL_TOOL = "BBBBBBBBBB";

    private static final String DEFAULT_WINDEROSA_GASKET_KIT_TOP_END = "AAAAAAAAAA";
    private static final String UPDATED_WINDEROSA_GASKET_KIT_TOP_END = "BBBBBBBBBB";

    private static final String DEFAULT_WINDEROSA_GASKET_KIT_OIL_SEALS = "AAAAAAAAAA";
    private static final String UPDATED_WINDEROSA_GASKET_KIT_OIL_SEALS = "BBBBBBBBBB";

    private static final String DEFAULT_OEM_EXHAUST_GASKET = "AAAAAAAAAA";
    private static final String UPDATED_OEM_EXHAUST_GASKET = "BBBBBBBBBB";

    private static final String DEFAULT_WINDEROSA_GASKET_EXHAUST = "AAAAAAAAAA";
    private static final String UPDATED_WINDEROSA_GASKET_EXHAUST = "BBBBBBBBBB";

    private static final String DEFAULT_WINDEROSA_WATER_PUMP_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_WINDEROSA_WATER_PUMP_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_CONNECTING_ROD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_CONNECTING_ROD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_COUNTER_BAL_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_COUNTER_BAL_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_BE_REBUILD_KIT = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_BE_REBUILD_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_BE_REBUILD_KIT_ST = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_BE_REBUILD_KIT_ST = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_CYLINDER_HEAD = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_CYLINDER_HEAD = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_MAIN_BEARING_SEAL_KIT = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_MAIN_BEARING_SEAL_KIT = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_TRANSMISSION_BEARINGS = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_TRANSMISSION_BEARINGS = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_WRIST_PIN_BEARINGS = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_WRIST_PIN_BEARINGS = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_1 = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_2 = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_3 = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE = "BBBBBBBBBB";

    private static final String DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST = "AAAAAAAAAA";
    private static final String UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST = "BBBBBBBBBB";

    @Autowired
    private BikeRepository bikeRepository;

    @Mock
    private BikeRepository bikeRepositoryMock;

    @Autowired
    private BikeMapper bikeMapper;
    

    @Mock
    private BikeService bikeServiceMock;

    @Autowired
    private BikeService bikeService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBikeMockMvc;

    private Bike bike;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BikeResource bikeResource = new BikeResource(bikeService);
        this.restBikeMockMvc = MockMvcBuilders.standaloneSetup(bikeResource)
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
    public static Bike createEntity(EntityManager em) {
        Bike bike = new Bike()
            .visibilityAU(DEFAULT_VISIBILITY_AU)
            .visibilityEU(DEFAULT_VISIBILITY_EU)
            .inactive(DEFAULT_INACTIVE)
            .oemconfirmed(DEFAULT_OEMCONFIRMED)
            .oesource(DEFAULT_OESOURCE)
            .epid(DEFAULT_EPID)
            .modeltype1(DEFAULT_MODELTYPE_1)
            .modeltype2(DEFAULT_MODELTYPE_2)
            .manufacturer(DEFAULT_MANUFACTURER)
            .strokes(DEFAULT_STROKES)
            .capacity(DEFAULT_CAPACITY)
            .modelName(DEFAULT_MODEL_NAME)
            .modelYearCode(DEFAULT_MODEL_YEAR_CODE)
            .modelTypeCode(DEFAULT_MODEL_TYPE_CODE)
            .year(DEFAULT_YEAR)
            .finalDriveType(DEFAULT_FINAL_DRIVE_TYPE)
            .categoryPath(DEFAULT_CATEGORY_PATH)
            .modelNotes(DEFAULT_MODEL_NOTES)
            .modelNotes2(DEFAULT_MODEL_NOTES_2)
            .modelNotes3(DEFAULT_MODEL_NOTES_3)
            .modelNotes4(DEFAULT_MODEL_NOTES_4)
            .modelInfoHTML(DEFAULT_MODEL_INFO_HTML)
            .oemFrontBrakeSystemType(DEFAULT_OEM_FRONT_BRAKE_SYSTEM_TYPE)
            .oemFrontBrakeDiscLeft(DEFAULT_OEM_FRONT_BRAKE_DISC_LEFT)
            .oemFrontBrakeDiscRight(DEFAULT_OEM_FRONT_BRAKE_DISC_RIGHT)
            .oemFrontBrakeDiscBolts(DEFAULT_OEM_FRONT_BRAKE_DISC_BOLTS)
            .oemFrontBDQTYPD(DEFAULT_OEM_FRONT_BDQTYPD)
            .oemFrontBrakeDiscABSRing(DEFAULT_OEM_FRONT_BRAKE_DISC_ABS_RING)
            .oemFrontBrakeCaliper1(DEFAULT_OEM_FRONT_BRAKE_CALIPER_1)
            .oemFrontBrakeCaliper2(DEFAULT_OEM_FRONT_BRAKE_CALIPER_2)
            .oemFrontBrakeCaliperPin(DEFAULT_OEM_FRONT_BRAKE_CALIPER_PIN)
            .oemFrontBrakePadsFrontL(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_L)
            .oemFrontBrakePadsFrontR(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_R)
            .oemFrontShoe(DEFAULT_OEM_FRONT_SHOE)
            .oemMidldleAxleBrakeDisc(DEFAULT_OEM_MIDLDLE_AXLE_BRAKE_DISC)
            .oemMiddleAxleBrakePads(DEFAULT_OEM_MIDDLE_AXLE_BRAKE_PADS)
            .oemRearBrakeSystemType(DEFAULT_OEM_REAR_BRAKE_SYSTEM_TYPE)
            .oeamRearBrakeDisc(DEFAULT_OEAM_REAR_BRAKE_DISC)
            .oeamRearBrakeDiscBolts(DEFAULT_OEAM_REAR_BRAKE_DISC_BOLTS)
            .oeamRearBrakeDiscBQTYPD(DEFAULT_OEAM_REAR_BRAKE_DISC_BQTYPD)
            .oemRearBrakeCaliper(DEFAULT_OEM_REAR_BRAKE_CALIPER)
            .oemRearBrakeCaliperPin(DEFAULT_OEM_REAR_BRAKE_CALIPER_PIN)
            .oemRearBrakePads1(DEFAULT_OEM_REAR_BRAKE_PADS_1)
            .oemRearBrakePads2(DEFAULT_OEM_REAR_BRAKE_PADS_2)
            .oemShoeRear(DEFAULT_OEM_SHOE_REAR)
            .oemShoeRear2(DEFAULT_OEM_SHOE_REAR_2)
            .oemSlaveCylinder(DEFAULT_OEM_SLAVE_CYLINDER)
            .oemChainNo(DEFAULT_OEM_CHAIN_NO)
            .oemChainSize(DEFAULT_OEM_CHAIN_SIZE)
            .oemChainLinks(DEFAULT_OEM_CHAIN_LINKS)
            .oemFrontSprocket(DEFAULT_OEM_FRONT_SPROCKET)
            .oemFrontGearing(DEFAULT_OEM_FRONT_GEARING)
            .oemFrontGearingMin(DEFAULT_OEM_FRONT_GEARING_MIN)
            .oemFrontGearingMax(DEFAULT_OEM_FRONT_GEARING_MAX)
            .oemRearSprocket(DEFAULT_OEM_REAR_SPROCKET)
            .oemRearGearing(DEFAULT_OEM_REAR_GEARING)
            .oemRearGearingMin(DEFAULT_OEM_REAR_GEARING_MIN)
            .oemRearGearingMax(DEFAULT_OEM_REAR_GEARING_MAX)
            .finalDriveNotes(DEFAULT_FINAL_DRIVE_NOTES)
            .chainConvSize(DEFAULT_CHAIN_CONV_SIZE)
            .chainConvLinks(DEFAULT_CHAIN_CONV_LINKS)
            .oemFrontWheel(DEFAULT_OEM_FRONT_WHEEL)
            .oemFrontWheelType(DEFAULT_OEM_FRONT_WHEEL_TYPE)
            .oemFrontWheelFront(DEFAULT_OEM_FRONT_WHEEL_FRONT)
            .oemFrontWheelTyreSize(DEFAULT_OEM_FRONT_WHEEL_TYRE_SIZE)
            .oemFrontHub(DEFAULT_OEM_FRONT_HUB)
            .oemFrontWheelbearing1(DEFAULT_OEM_FRONT_WHEELBEARING_1)
            .oemFrontWheelbearing2(DEFAULT_OEM_FRONT_WHEELBEARING_2)
            .oemFrontWheelSeal(DEFAULT_OEM_FRONT_WHEEL_SEAL)
            .oemRearWheel(DEFAULT_OEM_REAR_WHEEL)
            .oemRearWheelSize(DEFAULT_OEM_REAR_WHEEL_SIZE)
            .oemRearWheelTyre(DEFAULT_OEM_REAR_WHEEL_TYRE)
            .oemRearWheelBearing1(DEFAULT_OEM_REAR_WHEEL_BEARING_1)
            .oemRearWheelBearing2(DEFAULT_OEM_REAR_WHEEL_BEARING_2)
            .oemRearWheelSeal(DEFAULT_OEM_REAR_WHEEL_SEAL)
            .frontPadsDiffCaliper(DEFAULT_FRONT_PADS_DIFF_CALIPER)
            .qtyBH(DEFAULT_QTY_BH)
            .handbrakeParking(DEFAULT_HANDBRAKE_PARKING)
            .addNotesToBike(DEFAULT_ADD_NOTES_TO_BIKE)
            .dateAndID(DEFAULT_DATE_AND_ID)
            .source(DEFAULT_SOURCE)
            .tuvRequired(DEFAULT_TUV_REQUIRED)
            .tuvTypeCode(DEFAULT_TUV_TYPE_CODE)
            .abekba(DEFAULT_ABEKBA)
            .tuvFrontDisc(DEFAULT_TUV_FRONT_DISC)
            .tuvRearDisc(DEFAULT_TUV_REAR_DISC)
            .bremboBrakeDiscFrontRef(DEFAULT_BREMBO_BRAKE_DISC_FRONT_REF)
            .ebcBrakeDiscFrontRef(DEFAULT_EBC_BRAKE_DISC_FRONT_REF)
            .trwBrakeDiscFrontRef(DEFAULT_TRW_BRAKE_DISC_FRONT_REF)
            .mgearBrakeDiscFrontLeftRef(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF)
            .mgearBrakeDiscFrontRightRef(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF)
            .mgearBrakeDiscFrontCheck(DEFAULT_MGEAR_BRAKE_DISC_FRONT_CHECK)
            .mgearBrakeDiscFrontLeftRef2(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2)
            .mgearBrakeDiscFrontRightRef2(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2)
            .mgearBrakeDiscFNeto(DEFAULT_MGEAR_BRAKE_DISC_F_NETO)
            .motodiscBrakeDiscFNeto(DEFAULT_MOTODISC_BRAKE_DISC_F_NETO)
            .ebcBrakePadsFrontLRef(DEFAULT_EBC_BRAKE_PADS_FRONT_L_REF)
            .ebcBrakePadsFrontRRef(DEFAULT_EBC_BRAKE_PADS_FRONT_R_REF)
            .mgearBrakePadsFrontLRef(DEFAULT_MGEAR_BRAKE_PADS_FRONT_L_REF)
            .mgearBrakePadsFrontRRef(DEFAULT_MGEAR_BRAKE_PADS_FRONT_R_REF)
            .mgearBrakePadsFNeto(DEFAULT_MGEAR_BRAKE_PADS_F_NETO)
            .motoPadBrakePadsFrontLRef(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_L_REF)
            .motoPadBrakePadsFrontRRef(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_R_REF)
            .motopadBrakePadsFNeto(DEFAULT_MOTOPAD_BRAKE_PADS_F_NETO)
            .allBallsFCRebuildKit1(DEFAULT_ALL_BALLS_FC_REBUILD_KIT_1)
            .allBallsFCPin(DEFAULT_ALL_BALLS_FC_PIN)
            .allBallsFMCyRebuildKit(DEFAULT_ALL_BALLS_FM_CY_REBUILD_KIT)
            .allBallsFSCRebuildKit(DEFAULT_ALL_BALLS_FSC_REBUILD_KIT)
            .newfrenShoeFront(DEFAULT_NEWFREN_SHOE_FRONT)
            .mgearMiddleAxleBrakeDiscNeto(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO)
            .mgearMiddleAxleBrakeDiscNeto2(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2)
            .mgearMiddleAxleBrakePadNeto(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO)
            .mgearMiddleAxleBrakePadNeto2(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2)
            .mgearBrakePadsParkRef(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF)
            .mgearBrakePadsParkRef2(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF_2)
            .ebcBrakeDiscRearRef(DEFAULT_EBC_BRAKE_DISC_REAR_REF)
            .bremboBrakeDiscRearRef(DEFAULT_BREMBO_BRAKE_DISC_REAR_REF)
            .mgearBrakeDiscRearRef(DEFAULT_MGEAR_BRAKE_DISC_REAR_REF)
            .trwBrakeDiscRearRef(DEFAULT_TRW_BRAKE_DISC_REAR_REF)
            .mgearBrakeDiscRear(DEFAULT_MGEAR_BRAKE_DISC_REAR)
            .allBallsRCRebuildKit1(DEFAULT_ALL_BALLS_RC_REBUILD_KIT_1)
            .allBallsRearCaliperBolt(DEFAULT_ALL_BALLS_REAR_CALIPER_BOLT)
            .allBallsRMCrRebuildKit(DEFAULT_ALL_BALLS_RM_CR_REBUILD_KIT)
            .ebcBrakePadsRearRef(DEFAULT_EBC_BRAKE_PADS_REAR_REF)
            .mgearBrakePadsRearNeto(DEFAULT_MGEAR_BRAKE_PADS_REAR_NETO)
            .newfrenShoeRear(DEFAULT_NEWFREN_SHOE_REAR)
            .allBallsRearBrakePedalKit(DEFAULT_ALL_BALLS_REAR_BRAKE_PEDAL_KIT)
            .allBallsCSCRebuildKit(DEFAULT_ALL_BALLS_CSC_REBUILD_KIT)
            .frontJTRefFront(DEFAULT_FRONT_JT_REF_FRONT)
            .esjotRefFront(DEFAULT_ESJOT_REF_FRONT)
            .mgearRefFront(DEFAULT_MGEAR_REF_FRONT)
            .mogemaRefFront(DEFAULT_MOGEMA_REF_FRONT)
            .supersproxRefFront(DEFAULT_SUPERSPROX_REF_FRONT)
            .esjotRefRear(DEFAULT_ESJOT_REF_REAR)
            .jtRefRear(DEFAULT_JT_REF_REAR)
            .mgearRefRear(DEFAULT_MGEAR_REF_REAR)
            .mogemaRefRear(DEFAULT_MOGEMA_REF_REAR)
            .supersproxRefRear(DEFAULT_SUPERSPROX_REF_REAR)
            .esjotRefFrontConv(DEFAULT_ESJOT_REF_FRONT_CONV)
            .jtSprocketRef(DEFAULT_JT_SPROCKET_REF)
            .mgearRefFrontConv(DEFAULT_MGEAR_REF_FRONT_CONV)
            .mogemarefFrontConv(DEFAULT_MOGEMAREF_FRONT_CONV)
            .supersproxRefFrontConv(DEFAULT_SUPERSPROX_REF_FRONT_CONV)
            .conversionChain(DEFAULT_CONVERSION_CHAIN)
            .mgearSprocketRearConv(DEFAULT_MGEAR_SPROCKET_REAR_CONV)
            .esjotRefRearConv(DEFAULT_ESJOT_REF_REAR_CONV)
            .mgearRefRearConv(DEFAULT_MGEAR_REF_REAR_CONV)
            .mogemaRefRearConv(DEFAULT_MOGEMA_REF_REAR_CONV)
            .supersproxRefRearConv(DEFAULT_SUPERSPROX_REF_REAR_CONV)
            .allBallsFWBearingKit1(DEFAULT_ALL_BALLS_FW_BEARING_KIT_1)
            .allBallsFWBearingKit2(DEFAULT_ALL_BALLS_FW_BEARING_KIT_2)
            .allBallsRWBearingKit1(DEFAULT_ALL_BALLS_RW_BEARING_KIT_1)
            .allBallsRWBearingKit2(DEFAULT_ALL_BALLS_RW_BEARING_KIT_2)
            .allBallsRWBearingUpgrade(DEFAULT_ALL_BALLS_RW_BEARING_UPGRADE)
            .oemSparkPlug(DEFAULT_OEM_SPARK_PLUG)
            .oemSparkPlugQTY(DEFAULT_OEM_SPARK_PLUG_QTY)
            .ngkSparkPlugSKUs(DEFAULT_NGK_SPARK_PLUG_SK_US)
            .oemAlternator(DEFAULT_OEM_ALTERNATOR)
            .oemVoltageRegulator(DEFAULT_OEM_VOLTAGE_REGULATOR)
            .arrowheadAlternator(DEFAULT_ARROWHEAD_ALTERNATOR)
            .arrowheadAlternator2(DEFAULT_ARROWHEAD_ALTERNATOR_2)
            .arrowheadCDIModule(DEFAULT_ARROWHEAD_CDI_MODULE)
            .arrowheadChargingCoil(DEFAULT_ARROWHEAD_CHARGING_COIL)
            .arrowheadIgnitionCoil(DEFAULT_ARROWHEAD_IGNITION_COIL)
            .arrowheadStatorCoil(DEFAULT_ARROWHEAD_STATOR_COIL)
            .arrowheadVoltageRegulator(DEFAULT_ARROWHEAD_VOLTAGE_REGULATOR)
            .arrowheadPowerShiftCM(DEFAULT_ARROWHEAD_POWER_SHIFT_CM)
            .arrowheadStarterDrive(DEFAULT_ARROWHEAD_STARTER_DRIVE)
            .arrowheadStarterMotor(DEFAULT_ARROWHEAD_STARTER_MOTOR)
            .arrowheadStarterRelay(DEFAULT_ARROWHEAD_STARTER_RELAY)
            .oemBattery(DEFAULT_OEM_BATTERY)
            .ssbAGMBattery(DEFAULT_SSB_AGM_BATTERY)
            .oemAirFilter(DEFAULT_OEM_AIR_FILTER)
            .knAirFilter(DEFAULT_KN_AIR_FILTER)
            .motorexAirFilter(DEFAULT_MOTOREX_AIR_FILTER)
            .motorexAirFilterPreoiled(DEFAULT_MOTOREX_AIR_FILTER_PREOILED)
            .oemOilFilter1(DEFAULT_OEM_OIL_FILTER_1)
            .knOilFilter1(DEFAULT_KN_OIL_FILTER_1)
            .oemOilFilter2(DEFAULT_OEM_OIL_FILTER_2)
            .knOilFilter2(DEFAULT_KN_OIL_FILTER_2)
            .motionProOilFilterMagnet(DEFAULT_MOTION_PRO_OIL_FILTER_MAGNET)
            .oemSteeringBearing(DEFAULT_OEM_STEERING_BEARING)
            .oemSteeringSeal(DEFAULT_OEM_STEERING_SEAL)
            .allBallsSBSealKit1(DEFAULT_ALL_BALLS_SB_SEAL_KIT_1)
            .allBallsSBSealKit2(DEFAULT_ALL_BALLS_SB_SEAL_KIT_2)
            .allBallsSBSealKitLower(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER)
            .allBallsSBSealKitLower2(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER_2)
            .allBallsCBSealKit(DEFAULT_ALL_BALLS_CB_SEAL_KIT)
            .oemForkAssemblyLeft(DEFAULT_OEM_FORK_ASSEMBLY_LEFT)
            .oemForkAssemblyRight(DEFAULT_OEM_FORK_ASSEMBLY_RIGHT)
            .oemForkSeals(DEFAULT_OEM_FORK_SEALS)
            .allBallsForkSeals(DEFAULT_ALL_BALLS_FORK_SEALS)
            .xprForkSeals(DEFAULT_XPR_FORK_SEALS)
            .allBallsForkBushingKit(DEFAULT_ALL_BALLS_FORK_BUSHING_KIT)
            .motionProMicroForkBleeder(DEFAULT_MOTION_PRO_MICRO_FORK_BLEEDER)
            .motionProCRProThottleKit(DEFAULT_MOTION_PRO_CR_PRO_THOTTLE_KIT)
            .oemCableSpeedo(DEFAULT_OEM_CABLE_SPEEDO)
            .motionProCableSpeedo(DEFAULT_MOTION_PRO_CABLE_SPEEDO)
            .motionProCableThrottleTube(DEFAULT_MOTION_PRO_CABLE_THROTTLE_TUBE)
            .crossproRadiatorGuard(DEFAULT_CROSSPRO_RADIATOR_GUARD)
            .oemClutchFibres(DEFAULT_OEM_CLUTCH_FIBRES)
            .oemClutchFibresSteels(DEFAULT_OEM_CLUTCH_FIBRES_STEELS)
            .newfrenClutchKit(DEFAULT_NEWFREN_CLUTCH_KIT)
            .newfrenClutchSpringKits(DEFAULT_NEWFREN_CLUTCH_SPRING_KITS)
            .allBallsCMCRebuiltKit(DEFAULT_ALL_BALLS_CMC_REBUILT_KIT)
            .wisecoForgedClutchBasket(DEFAULT_WISECO_FORGED_CLUTCH_BASKET)
            .wisecoBottemEndRebuildKit(DEFAULT_WISECO_BOTTEM_END_REBUILD_KIT)
            .wrenchRERebuildKit(DEFAULT_WRENCH_RE_REBUILD_KIT)
            .oemCarbAssembly(DEFAULT_OEM_CARB_ASSEMBLY)
            .allBallsCarbRepairKit(DEFAULT_ALL_BALLS_CARB_REPAIR_KIT)
            .allBallsCRMidBodyGasket1(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_1)
            .allBallsCRMidBodyGasket2(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_2)
            .allBallsFuelTapRepairKit(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT)
            .allBallsFuelTapRepairKit2(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2)
            .fuelStarFuelValveKit(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT)
            .fuelStarFuelValveKit2(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT_2)
            .fuelStarHoseClampKit(DEFAULT_FUEL_STAR_HOSE_CLAMP_KIT)
            .rgEngineCoverLHS(DEFAULT_RG_ENGINE_COVER_LHS)
            .rgTailTidy(DEFAULT_RG_TAIL_TIDY)
            .allBallsLBSealKit(DEFAULT_ALL_BALLS_LB_SEAL_KIT)
            .allBallsLRSBearingKit(DEFAULT_ALL_BALLS_LRS_BEARING_KIT)
            .allBallsURSBearingKit(DEFAULT_ALL_BALLS_URS_BEARING_KIT)
            .allBallsULSBearingKit(DEFAULT_ALL_BALLS_ULS_BEARING_KIT)
            .allBallsSBSealKit(DEFAULT_ALL_BALLS_SB_SEAL_KIT)
            .pivotWorksSTBearingKit(DEFAULT_PIVOT_WORKS_ST_BEARING_KIT)
            .pivotWorksSRebuildKit(DEFAULT_PIVOT_WORKS_S_REBUILD_KIT)
            .mpForkSealDriver(DEFAULT_MP_FORK_SEAL_DRIVER)
            .mpValveSealInstallTool(DEFAULT_MP_VALVE_SEAL_INSTALL_TOOL)
            .winderosaGasketKitTopEnd(DEFAULT_WINDEROSA_GASKET_KIT_TOP_END)
            .winderosaGasketKitOilSeals(DEFAULT_WINDEROSA_GASKET_KIT_OIL_SEALS)
            .oemExhaustGasket(DEFAULT_OEM_EXHAUST_GASKET)
            .winderosaGasketExhaust(DEFAULT_WINDEROSA_GASKET_EXHAUST)
            .winderosaWaterPumpRebuildKit(DEFAULT_WINDEROSA_WATER_PUMP_REBUILD_KIT)
            .hotRodsConnectingRodKit(DEFAULT_HOT_RODS_CONNECTING_ROD_KIT)
            .hotRodsCounterBalRebuildKit(DEFAULT_HOT_RODS_COUNTER_BAL_REBUILD_KIT)
            .hotRodsBERebuildKit(DEFAULT_HOT_RODS_BE_REBUILD_KIT)
            .hotRodsBERebuildKitSt(DEFAULT_HOT_RODS_BE_REBUILD_KIT_ST)
            .hotRodsCylinderHead(DEFAULT_HOT_RODS_CYLINDER_HEAD)
            .hotRodsMainBearingSealKit(DEFAULT_HOT_RODS_MAIN_BEARING_SEAL_KIT)
            .hotRodsTransmissionBearings(DEFAULT_HOT_RODS_TRANSMISSION_BEARINGS)
            .hotRodsWristPinBearings(DEFAULT_HOT_RODS_WRIST_PIN_BEARINGS)
            .hotRodsSOHCCamshaftStage1(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_1)
            .hotRodsSOHCCamshaftStage2(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_2)
            .hotRodsSOHCCamshaftStage3(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_3)
            .hotRodsDOHCCamshaftStage1Intake(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE)
            .hotRodsDOHCCamshaftStage1Exhaust(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST)
            .hotRodsDOHCCamshaftStage2Intake(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE)
            .hotRodsDOHCCamshaftStage2Exhaust(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST);
        return bike;
    }

    @Before
    public void initTest() {
        bike = createEntity(em);
    }

    @Test
    @Transactional
    public void createBike() throws Exception {
        int databaseSizeBeforeCreate = bikeRepository.findAll().size();

        // Create the Bike
        BikeDTO bikeDTO = bikeMapper.toDto(bike);
        restBikeMockMvc.perform(post("/api/bikes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeDTO)))
            .andExpect(status().isCreated());

        // Validate the Bike in the database
        List<Bike> bikeList = bikeRepository.findAll();
        assertThat(bikeList).hasSize(databaseSizeBeforeCreate + 1);
        Bike testBike = bikeList.get(bikeList.size() - 1);
        assertThat(testBike.getVisibilityAU()).isEqualTo(DEFAULT_VISIBILITY_AU);
        assertThat(testBike.getVisibilityEU()).isEqualTo(DEFAULT_VISIBILITY_EU);
        assertThat(testBike.getInactive()).isEqualTo(DEFAULT_INACTIVE);
        assertThat(testBike.getOemconfirmed()).isEqualTo(DEFAULT_OEMCONFIRMED);
        assertThat(testBike.getOesource()).isEqualTo(DEFAULT_OESOURCE);
        assertThat(testBike.getEpid()).isEqualTo(DEFAULT_EPID);
        assertThat(testBike.getModeltype1()).isEqualTo(DEFAULT_MODELTYPE_1);
        assertThat(testBike.getModeltype2()).isEqualTo(DEFAULT_MODELTYPE_2);
        assertThat(testBike.getManufacturer()).isEqualTo(DEFAULT_MANUFACTURER);
        assertThat(testBike.getStrokes()).isEqualTo(DEFAULT_STROKES);
        assertThat(testBike.getCapacity()).isEqualTo(DEFAULT_CAPACITY);
        assertThat(testBike.getModelName()).isEqualTo(DEFAULT_MODEL_NAME);
        assertThat(testBike.getModelYearCode()).isEqualTo(DEFAULT_MODEL_YEAR_CODE);
        assertThat(testBike.getModelTypeCode()).isEqualTo(DEFAULT_MODEL_TYPE_CODE);
        assertThat(testBike.getYear()).isEqualTo(DEFAULT_YEAR);
        assertThat(testBike.getFinalDriveType()).isEqualTo(DEFAULT_FINAL_DRIVE_TYPE);
        assertThat(testBike.getCategoryPath()).isEqualTo(DEFAULT_CATEGORY_PATH);
        assertThat(testBike.getModelNotes()).isEqualTo(DEFAULT_MODEL_NOTES);
        assertThat(testBike.getModelNotes2()).isEqualTo(DEFAULT_MODEL_NOTES_2);
        assertThat(testBike.getModelNotes3()).isEqualTo(DEFAULT_MODEL_NOTES_3);
        assertThat(testBike.getModelNotes4()).isEqualTo(DEFAULT_MODEL_NOTES_4);
        assertThat(testBike.getModelInfoHTML()).isEqualTo(DEFAULT_MODEL_INFO_HTML);
        assertThat(testBike.getOemFrontBrakeSystemType()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_SYSTEM_TYPE);
        assertThat(testBike.getOemFrontBrakeDiscLeft()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_DISC_LEFT);
        assertThat(testBike.getOemFrontBrakeDiscRight()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_DISC_RIGHT);
        assertThat(testBike.getOemFrontBrakeDiscBolts()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_DISC_BOLTS);
        assertThat(testBike.getOemFrontBDQTYPD()).isEqualTo(DEFAULT_OEM_FRONT_BDQTYPD);
        assertThat(testBike.getOemFrontBrakeDiscABSRing()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_DISC_ABS_RING);
        assertThat(testBike.getOemFrontBrakeCaliper1()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_CALIPER_1);
        assertThat(testBike.getOemFrontBrakeCaliper2()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_CALIPER_2);
        assertThat(testBike.getOemFrontBrakeCaliperPin()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_CALIPER_PIN);
        assertThat(testBike.getOemFrontBrakePadsFrontL()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_L);
        assertThat(testBike.getOemFrontBrakePadsFrontR()).isEqualTo(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_R);
        assertThat(testBike.getOemFrontShoe()).isEqualTo(DEFAULT_OEM_FRONT_SHOE);
        assertThat(testBike.getOemMidldleAxleBrakeDisc()).isEqualTo(DEFAULT_OEM_MIDLDLE_AXLE_BRAKE_DISC);
        assertThat(testBike.getOemMiddleAxleBrakePads()).isEqualTo(DEFAULT_OEM_MIDDLE_AXLE_BRAKE_PADS);
        assertThat(testBike.getOemRearBrakeSystemType()).isEqualTo(DEFAULT_OEM_REAR_BRAKE_SYSTEM_TYPE);
        assertThat(testBike.getOeamRearBrakeDisc()).isEqualTo(DEFAULT_OEAM_REAR_BRAKE_DISC);
        assertThat(testBike.getOeamRearBrakeDiscBolts()).isEqualTo(DEFAULT_OEAM_REAR_BRAKE_DISC_BOLTS);
        assertThat(testBike.getOeamRearBrakeDiscBQTYPD()).isEqualTo(DEFAULT_OEAM_REAR_BRAKE_DISC_BQTYPD);
        assertThat(testBike.getOemRearBrakeCaliper()).isEqualTo(DEFAULT_OEM_REAR_BRAKE_CALIPER);
        assertThat(testBike.getOemRearBrakeCaliperPin()).isEqualTo(DEFAULT_OEM_REAR_BRAKE_CALIPER_PIN);
        assertThat(testBike.getOemRearBrakePads1()).isEqualTo(DEFAULT_OEM_REAR_BRAKE_PADS_1);
        assertThat(testBike.getOemRearBrakePads2()).isEqualTo(DEFAULT_OEM_REAR_BRAKE_PADS_2);
        assertThat(testBike.getOemShoeRear()).isEqualTo(DEFAULT_OEM_SHOE_REAR);
        assertThat(testBike.getOemShoeRear2()).isEqualTo(DEFAULT_OEM_SHOE_REAR_2);
        assertThat(testBike.getOemSlaveCylinder()).isEqualTo(DEFAULT_OEM_SLAVE_CYLINDER);
        assertThat(testBike.getOemChainNo()).isEqualTo(DEFAULT_OEM_CHAIN_NO);
        assertThat(testBike.getOemChainSize()).isEqualTo(DEFAULT_OEM_CHAIN_SIZE);
        assertThat(testBike.getOemChainLinks()).isEqualTo(DEFAULT_OEM_CHAIN_LINKS);
        assertThat(testBike.getOemFrontSprocket()).isEqualTo(DEFAULT_OEM_FRONT_SPROCKET);
        assertThat(testBike.getOemFrontGearing()).isEqualTo(DEFAULT_OEM_FRONT_GEARING);
        assertThat(testBike.getOemFrontGearingMin()).isEqualTo(DEFAULT_OEM_FRONT_GEARING_MIN);
        assertThat(testBike.getOemFrontGearingMax()).isEqualTo(DEFAULT_OEM_FRONT_GEARING_MAX);
        assertThat(testBike.getOemRearSprocket()).isEqualTo(DEFAULT_OEM_REAR_SPROCKET);
        assertThat(testBike.getOemRearGearing()).isEqualTo(DEFAULT_OEM_REAR_GEARING);
        assertThat(testBike.getOemRearGearingMin()).isEqualTo(DEFAULT_OEM_REAR_GEARING_MIN);
        assertThat(testBike.getOemRearGearingMax()).isEqualTo(DEFAULT_OEM_REAR_GEARING_MAX);
        assertThat(testBike.getFinalDriveNotes()).isEqualTo(DEFAULT_FINAL_DRIVE_NOTES);
        assertThat(testBike.getChainConvSize()).isEqualTo(DEFAULT_CHAIN_CONV_SIZE);
        assertThat(testBike.getChainConvLinks()).isEqualTo(DEFAULT_CHAIN_CONV_LINKS);
        assertThat(testBike.getOemFrontWheel()).isEqualTo(DEFAULT_OEM_FRONT_WHEEL);
        assertThat(testBike.getOemFrontWheelType()).isEqualTo(DEFAULT_OEM_FRONT_WHEEL_TYPE);
        assertThat(testBike.getOemFrontWheelFront()).isEqualTo(DEFAULT_OEM_FRONT_WHEEL_FRONT);
        assertThat(testBike.getOemFrontWheelTyreSize()).isEqualTo(DEFAULT_OEM_FRONT_WHEEL_TYRE_SIZE);
        assertThat(testBike.getOemFrontHub()).isEqualTo(DEFAULT_OEM_FRONT_HUB);
        assertThat(testBike.getOemFrontWheelbearing1()).isEqualTo(DEFAULT_OEM_FRONT_WHEELBEARING_1);
        assertThat(testBike.getOemFrontWheelbearing2()).isEqualTo(DEFAULT_OEM_FRONT_WHEELBEARING_2);
        assertThat(testBike.getOemFrontWheelSeal()).isEqualTo(DEFAULT_OEM_FRONT_WHEEL_SEAL);
        assertThat(testBike.getOemRearWheel()).isEqualTo(DEFAULT_OEM_REAR_WHEEL);
        assertThat(testBike.getOemRearWheelSize()).isEqualTo(DEFAULT_OEM_REAR_WHEEL_SIZE);
        assertThat(testBike.getOemRearWheelTyre()).isEqualTo(DEFAULT_OEM_REAR_WHEEL_TYRE);
        assertThat(testBike.getOemRearWheelBearing1()).isEqualTo(DEFAULT_OEM_REAR_WHEEL_BEARING_1);
        assertThat(testBike.getOemRearWheelBearing2()).isEqualTo(DEFAULT_OEM_REAR_WHEEL_BEARING_2);
        assertThat(testBike.getOemRearWheelSeal()).isEqualTo(DEFAULT_OEM_REAR_WHEEL_SEAL);
        assertThat(testBike.getFrontPadsDiffCaliper()).isEqualTo(DEFAULT_FRONT_PADS_DIFF_CALIPER);
        assertThat(testBike.getQtyBH()).isEqualTo(DEFAULT_QTY_BH);
        assertThat(testBike.getHandbrakeParking()).isEqualTo(DEFAULT_HANDBRAKE_PARKING);
        assertThat(testBike.getAddNotesToBike()).isEqualTo(DEFAULT_ADD_NOTES_TO_BIKE);
        assertThat(testBike.getDateAndID()).isEqualTo(DEFAULT_DATE_AND_ID);
        assertThat(testBike.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testBike.getTuvRequired()).isEqualTo(DEFAULT_TUV_REQUIRED);
        assertThat(testBike.getTuvTypeCode()).isEqualTo(DEFAULT_TUV_TYPE_CODE);
        assertThat(testBike.getAbekba()).isEqualTo(DEFAULT_ABEKBA);
        assertThat(testBike.getTuvFrontDisc()).isEqualTo(DEFAULT_TUV_FRONT_DISC);
        assertThat(testBike.getTuvRearDisc()).isEqualTo(DEFAULT_TUV_REAR_DISC);
        assertThat(testBike.getBremboBrakeDiscFrontRef()).isEqualTo(DEFAULT_BREMBO_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getEbcBrakeDiscFrontRef()).isEqualTo(DEFAULT_EBC_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getTrwBrakeDiscFrontRef()).isEqualTo(DEFAULT_TRW_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontLeftRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontRightRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontCheck()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_FRONT_CHECK);
        assertThat(testBike.getMgearBrakeDiscFrontLeftRef2()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2);
        assertThat(testBike.getMgearBrakeDiscFrontRightRef2()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2);
        assertThat(testBike.getMgearBrakeDiscFNeto()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_F_NETO);
        assertThat(testBike.getMotodiscBrakeDiscFNeto()).isEqualTo(DEFAULT_MOTODISC_BRAKE_DISC_F_NETO);
        assertThat(testBike.getEbcBrakePadsFrontLRef()).isEqualTo(DEFAULT_EBC_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getEbcBrakePadsFrontRRef()).isEqualTo(DEFAULT_EBC_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMgearBrakePadsFrontLRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getMgearBrakePadsFrontRRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMgearBrakePadsFNeto()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_F_NETO);
        assertThat(testBike.getMotoPadBrakePadsFrontLRef()).isEqualTo(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getMotoPadBrakePadsFrontRRef()).isEqualTo(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMotopadBrakePadsFNeto()).isEqualTo(DEFAULT_MOTOPAD_BRAKE_PADS_F_NETO);
        assertThat(testBike.getAllBallsFCRebuildKit1()).isEqualTo(DEFAULT_ALL_BALLS_FC_REBUILD_KIT_1);
        assertThat(testBike.getAllBallsFCPin()).isEqualTo(DEFAULT_ALL_BALLS_FC_PIN);
        assertThat(testBike.getAllBallsFMCyRebuildKit()).isEqualTo(DEFAULT_ALL_BALLS_FM_CY_REBUILD_KIT);
        assertThat(testBike.getAllBallsFSCRebuildKit()).isEqualTo(DEFAULT_ALL_BALLS_FSC_REBUILD_KIT);
        assertThat(testBike.getNewfrenShoeFront()).isEqualTo(DEFAULT_NEWFREN_SHOE_FRONT);
        assertThat(testBike.getMgearMiddleAxleBrakeDiscNeto()).isEqualTo(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO);
        assertThat(testBike.getMgearMiddleAxleBrakeDiscNeto2()).isEqualTo(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2);
        assertThat(testBike.getMgearMiddleAxleBrakePadNeto()).isEqualTo(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO);
        assertThat(testBike.getMgearMiddleAxleBrakePadNeto2()).isEqualTo(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2);
        assertThat(testBike.getMgearBrakePadsParkRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF);
        assertThat(testBike.getMgearBrakePadsParkRef2()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF_2);
        assertThat(testBike.getEbcBrakeDiscRearRef()).isEqualTo(DEFAULT_EBC_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getBremboBrakeDiscRearRef()).isEqualTo(DEFAULT_BREMBO_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getMgearBrakeDiscRearRef()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getTrwBrakeDiscRearRef()).isEqualTo(DEFAULT_TRW_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getMgearBrakeDiscRear()).isEqualTo(DEFAULT_MGEAR_BRAKE_DISC_REAR);
        assertThat(testBike.getAllBallsRCRebuildKit1()).isEqualTo(DEFAULT_ALL_BALLS_RC_REBUILD_KIT_1);
        assertThat(testBike.getAllBallsRearCaliperBolt()).isEqualTo(DEFAULT_ALL_BALLS_REAR_CALIPER_BOLT);
        assertThat(testBike.getAllBallsRMCrRebuildKit()).isEqualTo(DEFAULT_ALL_BALLS_RM_CR_REBUILD_KIT);
        assertThat(testBike.getEbcBrakePadsRearRef()).isEqualTo(DEFAULT_EBC_BRAKE_PADS_REAR_REF);
        assertThat(testBike.getMgearBrakePadsRearNeto()).isEqualTo(DEFAULT_MGEAR_BRAKE_PADS_REAR_NETO);
        assertThat(testBike.getNewfrenShoeRear()).isEqualTo(DEFAULT_NEWFREN_SHOE_REAR);
        assertThat(testBike.getAllBallsRearBrakePedalKit()).isEqualTo(DEFAULT_ALL_BALLS_REAR_BRAKE_PEDAL_KIT);
        assertThat(testBike.getAllBallsCSCRebuildKit()).isEqualTo(DEFAULT_ALL_BALLS_CSC_REBUILD_KIT);
        assertThat(testBike.getFrontJTRefFront()).isEqualTo(DEFAULT_FRONT_JT_REF_FRONT);
        assertThat(testBike.getEsjotRefFront()).isEqualTo(DEFAULT_ESJOT_REF_FRONT);
        assertThat(testBike.getMgearRefFront()).isEqualTo(DEFAULT_MGEAR_REF_FRONT);
        assertThat(testBike.getMogemaRefFront()).isEqualTo(DEFAULT_MOGEMA_REF_FRONT);
        assertThat(testBike.getSupersproxRefFront()).isEqualTo(DEFAULT_SUPERSPROX_REF_FRONT);
        assertThat(testBike.getEsjotRefRear()).isEqualTo(DEFAULT_ESJOT_REF_REAR);
        assertThat(testBike.getJtRefRear()).isEqualTo(DEFAULT_JT_REF_REAR);
        assertThat(testBike.getMgearRefRear()).isEqualTo(DEFAULT_MGEAR_REF_REAR);
        assertThat(testBike.getMogemaRefRear()).isEqualTo(DEFAULT_MOGEMA_REF_REAR);
        assertThat(testBike.getSupersproxRefRear()).isEqualTo(DEFAULT_SUPERSPROX_REF_REAR);
        assertThat(testBike.getEsjotRefFrontConv()).isEqualTo(DEFAULT_ESJOT_REF_FRONT_CONV);
        assertThat(testBike.getJtSprocketRef()).isEqualTo(DEFAULT_JT_SPROCKET_REF);
        assertThat(testBike.getMgearRefFrontConv()).isEqualTo(DEFAULT_MGEAR_REF_FRONT_CONV);
        assertThat(testBike.getMogemarefFrontConv()).isEqualTo(DEFAULT_MOGEMAREF_FRONT_CONV);
        assertThat(testBike.getSupersproxRefFrontConv()).isEqualTo(DEFAULT_SUPERSPROX_REF_FRONT_CONV);
        assertThat(testBike.getConversionChain()).isEqualTo(DEFAULT_CONVERSION_CHAIN);
        assertThat(testBike.getMgearSprocketRearConv()).isEqualTo(DEFAULT_MGEAR_SPROCKET_REAR_CONV);
        assertThat(testBike.getEsjotRefRearConv()).isEqualTo(DEFAULT_ESJOT_REF_REAR_CONV);
        assertThat(testBike.getMgearRefRearConv()).isEqualTo(DEFAULT_MGEAR_REF_REAR_CONV);
        assertThat(testBike.getMogemaRefRearConv()).isEqualTo(DEFAULT_MOGEMA_REF_REAR_CONV);
        assertThat(testBike.getSupersproxRefRearConv()).isEqualTo(DEFAULT_SUPERSPROX_REF_REAR_CONV);
        assertThat(testBike.getAllBallsFWBearingKit1()).isEqualTo(DEFAULT_ALL_BALLS_FW_BEARING_KIT_1);
        assertThat(testBike.getAllBallsFWBearingKit2()).isEqualTo(DEFAULT_ALL_BALLS_FW_BEARING_KIT_2);
        assertThat(testBike.getAllBallsRWBearingKit1()).isEqualTo(DEFAULT_ALL_BALLS_RW_BEARING_KIT_1);
        assertThat(testBike.getAllBallsRWBearingKit2()).isEqualTo(DEFAULT_ALL_BALLS_RW_BEARING_KIT_2);
        assertThat(testBike.getAllBallsRWBearingUpgrade()).isEqualTo(DEFAULT_ALL_BALLS_RW_BEARING_UPGRADE);
        assertThat(testBike.getOemSparkPlug()).isEqualTo(DEFAULT_OEM_SPARK_PLUG);
        assertThat(testBike.getOemSparkPlugQTY()).isEqualTo(DEFAULT_OEM_SPARK_PLUG_QTY);
        assertThat(testBike.getNgkSparkPlugSKUs()).isEqualTo(DEFAULT_NGK_SPARK_PLUG_SK_US);
        assertThat(testBike.getOemAlternator()).isEqualTo(DEFAULT_OEM_ALTERNATOR);
        assertThat(testBike.getOemVoltageRegulator()).isEqualTo(DEFAULT_OEM_VOLTAGE_REGULATOR);
        assertThat(testBike.getArrowheadAlternator()).isEqualTo(DEFAULT_ARROWHEAD_ALTERNATOR);
        assertThat(testBike.getArrowheadAlternator2()).isEqualTo(DEFAULT_ARROWHEAD_ALTERNATOR_2);
        assertThat(testBike.getArrowheadCDIModule()).isEqualTo(DEFAULT_ARROWHEAD_CDI_MODULE);
        assertThat(testBike.getArrowheadChargingCoil()).isEqualTo(DEFAULT_ARROWHEAD_CHARGING_COIL);
        assertThat(testBike.getArrowheadIgnitionCoil()).isEqualTo(DEFAULT_ARROWHEAD_IGNITION_COIL);
        assertThat(testBike.getArrowheadStatorCoil()).isEqualTo(DEFAULT_ARROWHEAD_STATOR_COIL);
        assertThat(testBike.getArrowheadVoltageRegulator()).isEqualTo(DEFAULT_ARROWHEAD_VOLTAGE_REGULATOR);
        assertThat(testBike.getArrowheadPowerShiftCM()).isEqualTo(DEFAULT_ARROWHEAD_POWER_SHIFT_CM);
        assertThat(testBike.getArrowheadStarterDrive()).isEqualTo(DEFAULT_ARROWHEAD_STARTER_DRIVE);
        assertThat(testBike.getArrowheadStarterMotor()).isEqualTo(DEFAULT_ARROWHEAD_STARTER_MOTOR);
        assertThat(testBike.getArrowheadStarterRelay()).isEqualTo(DEFAULT_ARROWHEAD_STARTER_RELAY);
        assertThat(testBike.getOemBattery()).isEqualTo(DEFAULT_OEM_BATTERY);
        assertThat(testBike.getSsbAGMBattery()).isEqualTo(DEFAULT_SSB_AGM_BATTERY);
        assertThat(testBike.getOemAirFilter()).isEqualTo(DEFAULT_OEM_AIR_FILTER);
        assertThat(testBike.getKnAirFilter()).isEqualTo(DEFAULT_KN_AIR_FILTER);
        assertThat(testBike.getMotorexAirFilter()).isEqualTo(DEFAULT_MOTOREX_AIR_FILTER);
        assertThat(testBike.getMotorexAirFilterPreoiled()).isEqualTo(DEFAULT_MOTOREX_AIR_FILTER_PREOILED);
        assertThat(testBike.getOemOilFilter1()).isEqualTo(DEFAULT_OEM_OIL_FILTER_1);
        assertThat(testBike.getKnOilFilter1()).isEqualTo(DEFAULT_KN_OIL_FILTER_1);
        assertThat(testBike.getOemOilFilter2()).isEqualTo(DEFAULT_OEM_OIL_FILTER_2);
        assertThat(testBike.getKnOilFilter2()).isEqualTo(DEFAULT_KN_OIL_FILTER_2);
        assertThat(testBike.getMotionProOilFilterMagnet()).isEqualTo(DEFAULT_MOTION_PRO_OIL_FILTER_MAGNET);
        assertThat(testBike.getOemSteeringBearing()).isEqualTo(DEFAULT_OEM_STEERING_BEARING);
        assertThat(testBike.getOemSteeringSeal()).isEqualTo(DEFAULT_OEM_STEERING_SEAL);
        assertThat(testBike.getAllBallsSBSealKit1()).isEqualTo(DEFAULT_ALL_BALLS_SB_SEAL_KIT_1);
        assertThat(testBike.getAllBallsSBSealKit2()).isEqualTo(DEFAULT_ALL_BALLS_SB_SEAL_KIT_2);
        assertThat(testBike.getAllBallsSBSealKitLower()).isEqualTo(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER);
        assertThat(testBike.getAllBallsSBSealKitLower2()).isEqualTo(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER_2);
        assertThat(testBike.getAllBallsCBSealKit()).isEqualTo(DEFAULT_ALL_BALLS_CB_SEAL_KIT);
        assertThat(testBike.getOemForkAssemblyLeft()).isEqualTo(DEFAULT_OEM_FORK_ASSEMBLY_LEFT);
        assertThat(testBike.getOemForkAssemblyRight()).isEqualTo(DEFAULT_OEM_FORK_ASSEMBLY_RIGHT);
        assertThat(testBike.getOemForkSeals()).isEqualTo(DEFAULT_OEM_FORK_SEALS);
        assertThat(testBike.getAllBallsForkSeals()).isEqualTo(DEFAULT_ALL_BALLS_FORK_SEALS);
        assertThat(testBike.getXprForkSeals()).isEqualTo(DEFAULT_XPR_FORK_SEALS);
        assertThat(testBike.getAllBallsForkBushingKit()).isEqualTo(DEFAULT_ALL_BALLS_FORK_BUSHING_KIT);
        assertThat(testBike.getMotionProMicroForkBleeder()).isEqualTo(DEFAULT_MOTION_PRO_MICRO_FORK_BLEEDER);
        assertThat(testBike.getMotionProCRProThottleKit()).isEqualTo(DEFAULT_MOTION_PRO_CR_PRO_THOTTLE_KIT);
        assertThat(testBike.getOemCableSpeedo()).isEqualTo(DEFAULT_OEM_CABLE_SPEEDO);
        assertThat(testBike.getMotionProCableSpeedo()).isEqualTo(DEFAULT_MOTION_PRO_CABLE_SPEEDO);
        assertThat(testBike.getMotionProCableThrottleTube()).isEqualTo(DEFAULT_MOTION_PRO_CABLE_THROTTLE_TUBE);
        assertThat(testBike.getCrossproRadiatorGuard()).isEqualTo(DEFAULT_CROSSPRO_RADIATOR_GUARD);
        assertThat(testBike.getOemClutchFibres()).isEqualTo(DEFAULT_OEM_CLUTCH_FIBRES);
        assertThat(testBike.getOemClutchFibresSteels()).isEqualTo(DEFAULT_OEM_CLUTCH_FIBRES_STEELS);
        assertThat(testBike.getNewfrenClutchKit()).isEqualTo(DEFAULT_NEWFREN_CLUTCH_KIT);
        assertThat(testBike.getNewfrenClutchSpringKits()).isEqualTo(DEFAULT_NEWFREN_CLUTCH_SPRING_KITS);
        assertThat(testBike.getAllBallsCMCRebuiltKit()).isEqualTo(DEFAULT_ALL_BALLS_CMC_REBUILT_KIT);
        assertThat(testBike.getWisecoForgedClutchBasket()).isEqualTo(DEFAULT_WISECO_FORGED_CLUTCH_BASKET);
        assertThat(testBike.getWisecoBottemEndRebuildKit()).isEqualTo(DEFAULT_WISECO_BOTTEM_END_REBUILD_KIT);
        assertThat(testBike.getWrenchRERebuildKit()).isEqualTo(DEFAULT_WRENCH_RE_REBUILD_KIT);
        assertThat(testBike.getOemCarbAssembly()).isEqualTo(DEFAULT_OEM_CARB_ASSEMBLY);
        assertThat(testBike.getAllBallsCarbRepairKit()).isEqualTo(DEFAULT_ALL_BALLS_CARB_REPAIR_KIT);
        assertThat(testBike.getAllBallsCRMidBodyGasket1()).isEqualTo(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_1);
        assertThat(testBike.getAllBallsCRMidBodyGasket2()).isEqualTo(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_2);
        assertThat(testBike.getAllBallsFuelTapRepairKit()).isEqualTo(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT);
        assertThat(testBike.getAllBallsFuelTapRepairKit2()).isEqualTo(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2);
        assertThat(testBike.getFuelStarFuelValveKit()).isEqualTo(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT);
        assertThat(testBike.getFuelStarFuelValveKit2()).isEqualTo(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT_2);
        assertThat(testBike.getFuelStarHoseClampKit()).isEqualTo(DEFAULT_FUEL_STAR_HOSE_CLAMP_KIT);
        assertThat(testBike.getRgEngineCoverLHS()).isEqualTo(DEFAULT_RG_ENGINE_COVER_LHS);
        assertThat(testBike.getRgTailTidy()).isEqualTo(DEFAULT_RG_TAIL_TIDY);
        assertThat(testBike.getAllBallsLBSealKit()).isEqualTo(DEFAULT_ALL_BALLS_LB_SEAL_KIT);
        assertThat(testBike.getAllBallsLRSBearingKit()).isEqualTo(DEFAULT_ALL_BALLS_LRS_BEARING_KIT);
        assertThat(testBike.getAllBallsURSBearingKit()).isEqualTo(DEFAULT_ALL_BALLS_URS_BEARING_KIT);
        assertThat(testBike.getAllBallsULSBearingKit()).isEqualTo(DEFAULT_ALL_BALLS_ULS_BEARING_KIT);
        assertThat(testBike.getAllBallsSBSealKit()).isEqualTo(DEFAULT_ALL_BALLS_SB_SEAL_KIT);
        assertThat(testBike.getPivotWorksSTBearingKit()).isEqualTo(DEFAULT_PIVOT_WORKS_ST_BEARING_KIT);
        assertThat(testBike.getPivotWorksSRebuildKit()).isEqualTo(DEFAULT_PIVOT_WORKS_S_REBUILD_KIT);
        assertThat(testBike.getMpForkSealDriver()).isEqualTo(DEFAULT_MP_FORK_SEAL_DRIVER);
        assertThat(testBike.getMpValveSealInstallTool()).isEqualTo(DEFAULT_MP_VALVE_SEAL_INSTALL_TOOL);
        assertThat(testBike.getWinderosaGasketKitTopEnd()).isEqualTo(DEFAULT_WINDEROSA_GASKET_KIT_TOP_END);
        assertThat(testBike.getWinderosaGasketKitOilSeals()).isEqualTo(DEFAULT_WINDEROSA_GASKET_KIT_OIL_SEALS);
        assertThat(testBike.getOemExhaustGasket()).isEqualTo(DEFAULT_OEM_EXHAUST_GASKET);
        assertThat(testBike.getWinderosaGasketExhaust()).isEqualTo(DEFAULT_WINDEROSA_GASKET_EXHAUST);
        assertThat(testBike.getWinderosaWaterPumpRebuildKit()).isEqualTo(DEFAULT_WINDEROSA_WATER_PUMP_REBUILD_KIT);
        assertThat(testBike.getHotRodsConnectingRodKit()).isEqualTo(DEFAULT_HOT_RODS_CONNECTING_ROD_KIT);
        assertThat(testBike.getHotRodsCounterBalRebuildKit()).isEqualTo(DEFAULT_HOT_RODS_COUNTER_BAL_REBUILD_KIT);
        assertThat(testBike.getHotRodsBERebuildKit()).isEqualTo(DEFAULT_HOT_RODS_BE_REBUILD_KIT);
        assertThat(testBike.getHotRodsBERebuildKitSt()).isEqualTo(DEFAULT_HOT_RODS_BE_REBUILD_KIT_ST);
        assertThat(testBike.getHotRodsCylinderHead()).isEqualTo(DEFAULT_HOT_RODS_CYLINDER_HEAD);
        assertThat(testBike.getHotRodsMainBearingSealKit()).isEqualTo(DEFAULT_HOT_RODS_MAIN_BEARING_SEAL_KIT);
        assertThat(testBike.getHotRodsTransmissionBearings()).isEqualTo(DEFAULT_HOT_RODS_TRANSMISSION_BEARINGS);
        assertThat(testBike.getHotRodsWristPinBearings()).isEqualTo(DEFAULT_HOT_RODS_WRIST_PIN_BEARINGS);
        assertThat(testBike.getHotRodsSOHCCamshaftStage1()).isEqualTo(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_1);
        assertThat(testBike.getHotRodsSOHCCamshaftStage2()).isEqualTo(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_2);
        assertThat(testBike.getHotRodsSOHCCamshaftStage3()).isEqualTo(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_3);
        assertThat(testBike.getHotRodsDOHCCamshaftStage1Intake()).isEqualTo(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE);
        assertThat(testBike.getHotRodsDOHCCamshaftStage1Exhaust()).isEqualTo(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST);
        assertThat(testBike.getHotRodsDOHCCamshaftStage2Intake()).isEqualTo(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE);
        assertThat(testBike.getHotRodsDOHCCamshaftStage2Exhaust()).isEqualTo(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST);
    }

    @Test
    @Transactional
    public void createBikeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bikeRepository.findAll().size();

        // Create the Bike with an existing ID
        bike.setId(1L);
        BikeDTO bikeDTO = bikeMapper.toDto(bike);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBikeMockMvc.perform(post("/api/bikes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Bike in the database
        List<Bike> bikeList = bikeRepository.findAll();
        assertThat(bikeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBikes() throws Exception {
        // Initialize the database
        bikeRepository.saveAndFlush(bike);

        // Get all the bikeList
        restBikeMockMvc.perform(get("/api/bikes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bike.getId().intValue())))
            .andExpect(jsonPath("$.[*].visibilityAU").value(hasItem(DEFAULT_VISIBILITY_AU.toString())))
            .andExpect(jsonPath("$.[*].visibilityEU").value(hasItem(DEFAULT_VISIBILITY_EU.toString())))
            .andExpect(jsonPath("$.[*].inactive").value(hasItem(DEFAULT_INACTIVE.toString())))
            .andExpect(jsonPath("$.[*].oemconfirmed").value(hasItem(DEFAULT_OEMCONFIRMED.toString())))
            .andExpect(jsonPath("$.[*].oesource").value(hasItem(DEFAULT_OESOURCE.toString())))
            .andExpect(jsonPath("$.[*].epid").value(hasItem(DEFAULT_EPID.intValue())))
            .andExpect(jsonPath("$.[*].modeltype1").value(hasItem(DEFAULT_MODELTYPE_1.toString())))
            .andExpect(jsonPath("$.[*].modeltype2").value(hasItem(DEFAULT_MODELTYPE_2.toString())))
            .andExpect(jsonPath("$.[*].manufacturer").value(hasItem(DEFAULT_MANUFACTURER.toString())))
            .andExpect(jsonPath("$.[*].strokes").value(hasItem(DEFAULT_STROKES.toString())))
            .andExpect(jsonPath("$.[*].capacity").value(hasItem(DEFAULT_CAPACITY.intValue())))
            .andExpect(jsonPath("$.[*].modelName").value(hasItem(DEFAULT_MODEL_NAME.toString())))
            .andExpect(jsonPath("$.[*].modelYearCode").value(hasItem(DEFAULT_MODEL_YEAR_CODE.toString())))
            .andExpect(jsonPath("$.[*].modelTypeCode").value(hasItem(DEFAULT_MODEL_TYPE_CODE.toString())))
            .andExpect(jsonPath("$.[*].year").value(hasItem(DEFAULT_YEAR.intValue())))
            .andExpect(jsonPath("$.[*].finalDriveType").value(hasItem(DEFAULT_FINAL_DRIVE_TYPE.toString())))
            .andExpect(jsonPath("$.[*].categoryPath").value(hasItem(DEFAULT_CATEGORY_PATH.toString())))
            .andExpect(jsonPath("$.[*].modelNotes").value(hasItem(DEFAULT_MODEL_NOTES.toString())))
            .andExpect(jsonPath("$.[*].modelNotes2").value(hasItem(DEFAULT_MODEL_NOTES_2.toString())))
            .andExpect(jsonPath("$.[*].modelNotes3").value(hasItem(DEFAULT_MODEL_NOTES_3.toString())))
            .andExpect(jsonPath("$.[*].modelNotes4").value(hasItem(DEFAULT_MODEL_NOTES_4.toString())))
            .andExpect(jsonPath("$.[*].modelInfoHTML").value(hasItem(DEFAULT_MODEL_INFO_HTML.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeSystemType").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_SYSTEM_TYPE.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeDiscLeft").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_DISC_LEFT.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeDiscRight").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_DISC_RIGHT.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeDiscBolts").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_DISC_BOLTS.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBDQTYPD").value(hasItem(DEFAULT_OEM_FRONT_BDQTYPD.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeDiscABSRing").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_DISC_ABS_RING.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeCaliper1").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_CALIPER_1.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeCaliper2").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_CALIPER_2.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakeCaliperPin").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_CALIPER_PIN.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakePadsFrontL").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_L.toString())))
            .andExpect(jsonPath("$.[*].oemFrontBrakePadsFrontR").value(hasItem(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_R.toString())))
            .andExpect(jsonPath("$.[*].oemFrontShoe").value(hasItem(DEFAULT_OEM_FRONT_SHOE.toString())))
            .andExpect(jsonPath("$.[*].oemMidldleAxleBrakeDisc").value(hasItem(DEFAULT_OEM_MIDLDLE_AXLE_BRAKE_DISC.toString())))
            .andExpect(jsonPath("$.[*].oemMiddleAxleBrakePads").value(hasItem(DEFAULT_OEM_MIDDLE_AXLE_BRAKE_PADS.toString())))
            .andExpect(jsonPath("$.[*].oemRearBrakeSystemType").value(hasItem(DEFAULT_OEM_REAR_BRAKE_SYSTEM_TYPE.toString())))
            .andExpect(jsonPath("$.[*].oeamRearBrakeDisc").value(hasItem(DEFAULT_OEAM_REAR_BRAKE_DISC.toString())))
            .andExpect(jsonPath("$.[*].oeamRearBrakeDiscBolts").value(hasItem(DEFAULT_OEAM_REAR_BRAKE_DISC_BOLTS.toString())))
            .andExpect(jsonPath("$.[*].oeamRearBrakeDiscBQTYPD").value(hasItem(DEFAULT_OEAM_REAR_BRAKE_DISC_BQTYPD.intValue())))
            .andExpect(jsonPath("$.[*].oemRearBrakeCaliper").value(hasItem(DEFAULT_OEM_REAR_BRAKE_CALIPER.toString())))
            .andExpect(jsonPath("$.[*].oemRearBrakeCaliperPin").value(hasItem(DEFAULT_OEM_REAR_BRAKE_CALIPER_PIN.toString())))
            .andExpect(jsonPath("$.[*].oemRearBrakePads1").value(hasItem(DEFAULT_OEM_REAR_BRAKE_PADS_1.toString())))
            .andExpect(jsonPath("$.[*].oemRearBrakePads2").value(hasItem(DEFAULT_OEM_REAR_BRAKE_PADS_2.toString())))
            .andExpect(jsonPath("$.[*].oemShoeRear").value(hasItem(DEFAULT_OEM_SHOE_REAR.toString())))
            .andExpect(jsonPath("$.[*].oemShoeRear2").value(hasItem(DEFAULT_OEM_SHOE_REAR_2.toString())))
            .andExpect(jsonPath("$.[*].oemSlaveCylinder").value(hasItem(DEFAULT_OEM_SLAVE_CYLINDER.toString())))
            .andExpect(jsonPath("$.[*].oemChainNo").value(hasItem(DEFAULT_OEM_CHAIN_NO.toString())))
            .andExpect(jsonPath("$.[*].oemChainSize").value(hasItem(DEFAULT_OEM_CHAIN_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].oemChainLinks").value(hasItem(DEFAULT_OEM_CHAIN_LINKS.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontSprocket").value(hasItem(DEFAULT_OEM_FRONT_SPROCKET.toString())))
            .andExpect(jsonPath("$.[*].oemFrontGearing").value(hasItem(DEFAULT_OEM_FRONT_GEARING.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontGearingMin").value(hasItem(DEFAULT_OEM_FRONT_GEARING_MIN.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontGearingMax").value(hasItem(DEFAULT_OEM_FRONT_GEARING_MAX.intValue())))
            .andExpect(jsonPath("$.[*].oemRearSprocket").value(hasItem(DEFAULT_OEM_REAR_SPROCKET.toString())))
            .andExpect(jsonPath("$.[*].oemRearGearing").value(hasItem(DEFAULT_OEM_REAR_GEARING.intValue())))
            .andExpect(jsonPath("$.[*].oemRearGearingMin").value(hasItem(DEFAULT_OEM_REAR_GEARING_MIN.intValue())))
            .andExpect(jsonPath("$.[*].oemRearGearingMax").value(hasItem(DEFAULT_OEM_REAR_GEARING_MAX.intValue())))
            .andExpect(jsonPath("$.[*].finalDriveNotes").value(hasItem(DEFAULT_FINAL_DRIVE_NOTES.toString())))
            .andExpect(jsonPath("$.[*].chainConvSize").value(hasItem(DEFAULT_CHAIN_CONV_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].chainConvLinks").value(hasItem(DEFAULT_CHAIN_CONV_LINKS.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontWheel").value(hasItem(DEFAULT_OEM_FRONT_WHEEL.toString())))
            .andExpect(jsonPath("$.[*].oemFrontWheelType").value(hasItem(DEFAULT_OEM_FRONT_WHEEL_TYPE.toString())))
            .andExpect(jsonPath("$.[*].oemFrontWheelFront").value(hasItem(DEFAULT_OEM_FRONT_WHEEL_FRONT.intValue())))
            .andExpect(jsonPath("$.[*].oemFrontWheelTyreSize").value(hasItem(DEFAULT_OEM_FRONT_WHEEL_TYRE_SIZE.toString())))
            .andExpect(jsonPath("$.[*].oemFrontHub").value(hasItem(DEFAULT_OEM_FRONT_HUB.toString())))
            .andExpect(jsonPath("$.[*].oemFrontWheelbearing1").value(hasItem(DEFAULT_OEM_FRONT_WHEELBEARING_1.toString())))
            .andExpect(jsonPath("$.[*].oemFrontWheelbearing2").value(hasItem(DEFAULT_OEM_FRONT_WHEELBEARING_2.toString())))
            .andExpect(jsonPath("$.[*].oemFrontWheelSeal").value(hasItem(DEFAULT_OEM_FRONT_WHEEL_SEAL.toString())))
            .andExpect(jsonPath("$.[*].oemRearWheel").value(hasItem(DEFAULT_OEM_REAR_WHEEL.toString())))
            .andExpect(jsonPath("$.[*].oemRearWheelSize").value(hasItem(DEFAULT_OEM_REAR_WHEEL_SIZE.intValue())))
            .andExpect(jsonPath("$.[*].oemRearWheelTyre").value(hasItem(DEFAULT_OEM_REAR_WHEEL_TYRE.toString())))
            .andExpect(jsonPath("$.[*].oemRearWheelBearing1").value(hasItem(DEFAULT_OEM_REAR_WHEEL_BEARING_1.toString())))
            .andExpect(jsonPath("$.[*].oemRearWheelBearing2").value(hasItem(DEFAULT_OEM_REAR_WHEEL_BEARING_2.toString())))
            .andExpect(jsonPath("$.[*].oemRearWheelSeal").value(hasItem(DEFAULT_OEM_REAR_WHEEL_SEAL.toString())))
            .andExpect(jsonPath("$.[*].frontPadsDiffCaliper").value(hasItem(DEFAULT_FRONT_PADS_DIFF_CALIPER.toString())))
            .andExpect(jsonPath("$.[*].qtyBH").value(hasItem(DEFAULT_QTY_BH.intValue())))
            .andExpect(jsonPath("$.[*].handbrakeParking").value(hasItem(DEFAULT_HANDBRAKE_PARKING.toString())))
            .andExpect(jsonPath("$.[*].addNotesToBike").value(hasItem(DEFAULT_ADD_NOTES_TO_BIKE.toString())))
            .andExpect(jsonPath("$.[*].dateAndID").value(hasItem(DEFAULT_DATE_AND_ID.toString())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE.toString())))
            .andExpect(jsonPath("$.[*].tuvRequired").value(hasItem(DEFAULT_TUV_REQUIRED.toString())))
            .andExpect(jsonPath("$.[*].tuvTypeCode").value(hasItem(DEFAULT_TUV_TYPE_CODE.toString())))
            .andExpect(jsonPath("$.[*].abekba").value(hasItem(DEFAULT_ABEKBA.toString())))
            .andExpect(jsonPath("$.[*].tuvFrontDisc").value(hasItem(DEFAULT_TUV_FRONT_DISC.toString())))
            .andExpect(jsonPath("$.[*].tuvRearDisc").value(hasItem(DEFAULT_TUV_REAR_DISC.toString())))
            .andExpect(jsonPath("$.[*].bremboBrakeDiscFrontRef").value(hasItem(DEFAULT_BREMBO_BRAKE_DISC_FRONT_REF.toString())))
            .andExpect(jsonPath("$.[*].ebcBrakeDiscFrontRef").value(hasItem(DEFAULT_EBC_BRAKE_DISC_FRONT_REF.toString())))
            .andExpect(jsonPath("$.[*].trwBrakeDiscFrontRef").value(hasItem(DEFAULT_TRW_BRAKE_DISC_FRONT_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFrontLeftRef").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFrontRightRef").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFrontCheck").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_FRONT_CHECK.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFrontLeftRef2").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFrontRightRef2").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscFNeto").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_F_NETO.toString())))
            .andExpect(jsonPath("$.[*].motodiscBrakeDiscFNeto").value(hasItem(DEFAULT_MOTODISC_BRAKE_DISC_F_NETO.toString())))
            .andExpect(jsonPath("$.[*].ebcBrakePadsFrontLRef").value(hasItem(DEFAULT_EBC_BRAKE_PADS_FRONT_L_REF.toString())))
            .andExpect(jsonPath("$.[*].ebcBrakePadsFrontRRef").value(hasItem(DEFAULT_EBC_BRAKE_PADS_FRONT_R_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsFrontLRef").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_FRONT_L_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsFrontRRef").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_FRONT_R_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsFNeto").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_F_NETO.toString())))
            .andExpect(jsonPath("$.[*].motoPadBrakePadsFrontLRef").value(hasItem(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_L_REF.toString())))
            .andExpect(jsonPath("$.[*].motoPadBrakePadsFrontRRef").value(hasItem(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_R_REF.toString())))
            .andExpect(jsonPath("$.[*].motopadBrakePadsFNeto").value(hasItem(DEFAULT_MOTOPAD_BRAKE_PADS_F_NETO.toString())))
            .andExpect(jsonPath("$.[*].allBallsFCRebuildKit1").value(hasItem(DEFAULT_ALL_BALLS_FC_REBUILD_KIT_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsFCPin").value(hasItem(DEFAULT_ALL_BALLS_FC_PIN.toString())))
            .andExpect(jsonPath("$.[*].allBallsFMCyRebuildKit").value(hasItem(DEFAULT_ALL_BALLS_FM_CY_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsFSCRebuildKit").value(hasItem(DEFAULT_ALL_BALLS_FSC_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].newfrenShoeFront").value(hasItem(DEFAULT_NEWFREN_SHOE_FRONT.toString())))
            .andExpect(jsonPath("$.[*].mgearMiddleAxleBrakeDiscNeto").value(hasItem(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO.toString())))
            .andExpect(jsonPath("$.[*].mgearMiddleAxleBrakeDiscNeto2").value(hasItem(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2.toString())))
            .andExpect(jsonPath("$.[*].mgearMiddleAxleBrakePadNeto").value(hasItem(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO.toString())))
            .andExpect(jsonPath("$.[*].mgearMiddleAxleBrakePadNeto2").value(hasItem(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsParkRef").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsParkRef2").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF_2.toString())))
            .andExpect(jsonPath("$.[*].ebcBrakeDiscRearRef").value(hasItem(DEFAULT_EBC_BRAKE_DISC_REAR_REF.toString())))
            .andExpect(jsonPath("$.[*].bremboBrakeDiscRearRef").value(hasItem(DEFAULT_BREMBO_BRAKE_DISC_REAR_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscRearRef").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_REAR_REF.toString())))
            .andExpect(jsonPath("$.[*].trwBrakeDiscRearRef").value(hasItem(DEFAULT_TRW_BRAKE_DISC_REAR_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakeDiscRear").value(hasItem(DEFAULT_MGEAR_BRAKE_DISC_REAR.toString())))
            .andExpect(jsonPath("$.[*].allBallsRCRebuildKit1").value(hasItem(DEFAULT_ALL_BALLS_RC_REBUILD_KIT_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsRearCaliperBolt").value(hasItem(DEFAULT_ALL_BALLS_REAR_CALIPER_BOLT.toString())))
            .andExpect(jsonPath("$.[*].allBallsRMCrRebuildKit").value(hasItem(DEFAULT_ALL_BALLS_RM_CR_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].ebcBrakePadsRearRef").value(hasItem(DEFAULT_EBC_BRAKE_PADS_REAR_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearBrakePadsRearNeto").value(hasItem(DEFAULT_MGEAR_BRAKE_PADS_REAR_NETO.toString())))
            .andExpect(jsonPath("$.[*].newfrenShoeRear").value(hasItem(DEFAULT_NEWFREN_SHOE_REAR.toString())))
            .andExpect(jsonPath("$.[*].allBallsRearBrakePedalKit").value(hasItem(DEFAULT_ALL_BALLS_REAR_BRAKE_PEDAL_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsCSCRebuildKit").value(hasItem(DEFAULT_ALL_BALLS_CSC_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].frontJTRefFront").value(hasItem(DEFAULT_FRONT_JT_REF_FRONT.toString())))
            .andExpect(jsonPath("$.[*].esjotRefFront").value(hasItem(DEFAULT_ESJOT_REF_FRONT.toString())))
            .andExpect(jsonPath("$.[*].mgearRefFront").value(hasItem(DEFAULT_MGEAR_REF_FRONT.toString())))
            .andExpect(jsonPath("$.[*].mogemaRefFront").value(hasItem(DEFAULT_MOGEMA_REF_FRONT.toString())))
            .andExpect(jsonPath("$.[*].supersproxRefFront").value(hasItem(DEFAULT_SUPERSPROX_REF_FRONT.toString())))
            .andExpect(jsonPath("$.[*].esjotRefRear").value(hasItem(DEFAULT_ESJOT_REF_REAR.toString())))
            .andExpect(jsonPath("$.[*].jtRefRear").value(hasItem(DEFAULT_JT_REF_REAR.toString())))
            .andExpect(jsonPath("$.[*].mgearRefRear").value(hasItem(DEFAULT_MGEAR_REF_REAR.toString())))
            .andExpect(jsonPath("$.[*].mogemaRefRear").value(hasItem(DEFAULT_MOGEMA_REF_REAR.toString())))
            .andExpect(jsonPath("$.[*].supersproxRefRear").value(hasItem(DEFAULT_SUPERSPROX_REF_REAR.toString())))
            .andExpect(jsonPath("$.[*].esjotRefFrontConv").value(hasItem(DEFAULT_ESJOT_REF_FRONT_CONV.toString())))
            .andExpect(jsonPath("$.[*].jtSprocketRef").value(hasItem(DEFAULT_JT_SPROCKET_REF.toString())))
            .andExpect(jsonPath("$.[*].mgearRefFrontConv").value(hasItem(DEFAULT_MGEAR_REF_FRONT_CONV.toString())))
            .andExpect(jsonPath("$.[*].mogemarefFrontConv").value(hasItem(DEFAULT_MOGEMAREF_FRONT_CONV.toString())))
            .andExpect(jsonPath("$.[*].supersproxRefFrontConv").value(hasItem(DEFAULT_SUPERSPROX_REF_FRONT_CONV.toString())))
            .andExpect(jsonPath("$.[*].conversionChain").value(hasItem(DEFAULT_CONVERSION_CHAIN.toString())))
            .andExpect(jsonPath("$.[*].mgearSprocketRearConv").value(hasItem(DEFAULT_MGEAR_SPROCKET_REAR_CONV.toString())))
            .andExpect(jsonPath("$.[*].esjotRefRearConv").value(hasItem(DEFAULT_ESJOT_REF_REAR_CONV.toString())))
            .andExpect(jsonPath("$.[*].mgearRefRearConv").value(hasItem(DEFAULT_MGEAR_REF_REAR_CONV.toString())))
            .andExpect(jsonPath("$.[*].mogemaRefRearConv").value(hasItem(DEFAULT_MOGEMA_REF_REAR_CONV.toString())))
            .andExpect(jsonPath("$.[*].supersproxRefRearConv").value(hasItem(DEFAULT_SUPERSPROX_REF_REAR_CONV.toString())))
            .andExpect(jsonPath("$.[*].allBallsFWBearingKit1").value(hasItem(DEFAULT_ALL_BALLS_FW_BEARING_KIT_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsFWBearingKit2").value(hasItem(DEFAULT_ALL_BALLS_FW_BEARING_KIT_2.toString())))
            .andExpect(jsonPath("$.[*].allBallsRWBearingKit1").value(hasItem(DEFAULT_ALL_BALLS_RW_BEARING_KIT_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsRWBearingKit2").value(hasItem(DEFAULT_ALL_BALLS_RW_BEARING_KIT_2.toString())))
            .andExpect(jsonPath("$.[*].allBallsRWBearingUpgrade").value(hasItem(DEFAULT_ALL_BALLS_RW_BEARING_UPGRADE.toString())))
            .andExpect(jsonPath("$.[*].oemSparkPlug").value(hasItem(DEFAULT_OEM_SPARK_PLUG.toString())))
            .andExpect(jsonPath("$.[*].oemSparkPlugQTY").value(hasItem(DEFAULT_OEM_SPARK_PLUG_QTY.intValue())))
            .andExpect(jsonPath("$.[*].ngkSparkPlugSKUs").value(hasItem(DEFAULT_NGK_SPARK_PLUG_SK_US.toString())))
            .andExpect(jsonPath("$.[*].oemAlternator").value(hasItem(DEFAULT_OEM_ALTERNATOR.toString())))
            .andExpect(jsonPath("$.[*].oemVoltageRegulator").value(hasItem(DEFAULT_OEM_VOLTAGE_REGULATOR.toString())))
            .andExpect(jsonPath("$.[*].arrowheadAlternator").value(hasItem(DEFAULT_ARROWHEAD_ALTERNATOR.toString())))
            .andExpect(jsonPath("$.[*].arrowheadAlternator2").value(hasItem(DEFAULT_ARROWHEAD_ALTERNATOR_2.toString())))
            .andExpect(jsonPath("$.[*].arrowheadCDIModule").value(hasItem(DEFAULT_ARROWHEAD_CDI_MODULE.toString())))
            .andExpect(jsonPath("$.[*].arrowheadChargingCoil").value(hasItem(DEFAULT_ARROWHEAD_CHARGING_COIL.toString())))
            .andExpect(jsonPath("$.[*].arrowheadIgnitionCoil").value(hasItem(DEFAULT_ARROWHEAD_IGNITION_COIL.toString())))
            .andExpect(jsonPath("$.[*].arrowheadStatorCoil").value(hasItem(DEFAULT_ARROWHEAD_STATOR_COIL.toString())))
            .andExpect(jsonPath("$.[*].arrowheadVoltageRegulator").value(hasItem(DEFAULT_ARROWHEAD_VOLTAGE_REGULATOR.toString())))
            .andExpect(jsonPath("$.[*].arrowheadPowerShiftCM").value(hasItem(DEFAULT_ARROWHEAD_POWER_SHIFT_CM.toString())))
            .andExpect(jsonPath("$.[*].arrowheadStarterDrive").value(hasItem(DEFAULT_ARROWHEAD_STARTER_DRIVE.toString())))
            .andExpect(jsonPath("$.[*].arrowheadStarterMotor").value(hasItem(DEFAULT_ARROWHEAD_STARTER_MOTOR.toString())))
            .andExpect(jsonPath("$.[*].arrowheadStarterRelay").value(hasItem(DEFAULT_ARROWHEAD_STARTER_RELAY.toString())))
            .andExpect(jsonPath("$.[*].oemBattery").value(hasItem(DEFAULT_OEM_BATTERY.toString())))
            .andExpect(jsonPath("$.[*].ssbAGMBattery").value(hasItem(DEFAULT_SSB_AGM_BATTERY.toString())))
            .andExpect(jsonPath("$.[*].oemAirFilter").value(hasItem(DEFAULT_OEM_AIR_FILTER.toString())))
            .andExpect(jsonPath("$.[*].knAirFilter").value(hasItem(DEFAULT_KN_AIR_FILTER.toString())))
            .andExpect(jsonPath("$.[*].motorexAirFilter").value(hasItem(DEFAULT_MOTOREX_AIR_FILTER.toString())))
            .andExpect(jsonPath("$.[*].motorexAirFilterPreoiled").value(hasItem(DEFAULT_MOTOREX_AIR_FILTER_PREOILED.toString())))
            .andExpect(jsonPath("$.[*].oemOilFilter1").value(hasItem(DEFAULT_OEM_OIL_FILTER_1.toString())))
            .andExpect(jsonPath("$.[*].knOilFilter1").value(hasItem(DEFAULT_KN_OIL_FILTER_1.toString())))
            .andExpect(jsonPath("$.[*].oemOilFilter2").value(hasItem(DEFAULT_OEM_OIL_FILTER_2.toString())))
            .andExpect(jsonPath("$.[*].knOilFilter2").value(hasItem(DEFAULT_KN_OIL_FILTER_2.toString())))
            .andExpect(jsonPath("$.[*].motionProOilFilterMagnet").value(hasItem(DEFAULT_MOTION_PRO_OIL_FILTER_MAGNET.toString())))
            .andExpect(jsonPath("$.[*].oemSteeringBearing").value(hasItem(DEFAULT_OEM_STEERING_BEARING.toString())))
            .andExpect(jsonPath("$.[*].oemSteeringSeal").value(hasItem(DEFAULT_OEM_STEERING_SEAL.toString())))
            .andExpect(jsonPath("$.[*].allBallsSBSealKit1").value(hasItem(DEFAULT_ALL_BALLS_SB_SEAL_KIT_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsSBSealKit2").value(hasItem(DEFAULT_ALL_BALLS_SB_SEAL_KIT_2.toString())))
            .andExpect(jsonPath("$.[*].allBallsSBSealKitLower").value(hasItem(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER.toString())))
            .andExpect(jsonPath("$.[*].allBallsSBSealKitLower2").value(hasItem(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER_2.toString())))
            .andExpect(jsonPath("$.[*].allBallsCBSealKit").value(hasItem(DEFAULT_ALL_BALLS_CB_SEAL_KIT.toString())))
            .andExpect(jsonPath("$.[*].oemForkAssemblyLeft").value(hasItem(DEFAULT_OEM_FORK_ASSEMBLY_LEFT.toString())))
            .andExpect(jsonPath("$.[*].oemForkAssemblyRight").value(hasItem(DEFAULT_OEM_FORK_ASSEMBLY_RIGHT.toString())))
            .andExpect(jsonPath("$.[*].oemForkSeals").value(hasItem(DEFAULT_OEM_FORK_SEALS.toString())))
            .andExpect(jsonPath("$.[*].allBallsForkSeals").value(hasItem(DEFAULT_ALL_BALLS_FORK_SEALS.toString())))
            .andExpect(jsonPath("$.[*].xprForkSeals").value(hasItem(DEFAULT_XPR_FORK_SEALS.toString())))
            .andExpect(jsonPath("$.[*].allBallsForkBushingKit").value(hasItem(DEFAULT_ALL_BALLS_FORK_BUSHING_KIT.toString())))
            .andExpect(jsonPath("$.[*].motionProMicroForkBleeder").value(hasItem(DEFAULT_MOTION_PRO_MICRO_FORK_BLEEDER.toString())))
            .andExpect(jsonPath("$.[*].motionProCRProThottleKit").value(hasItem(DEFAULT_MOTION_PRO_CR_PRO_THOTTLE_KIT.toString())))
            .andExpect(jsonPath("$.[*].oemCableSpeedo").value(hasItem(DEFAULT_OEM_CABLE_SPEEDO.toString())))
            .andExpect(jsonPath("$.[*].motionProCableSpeedo").value(hasItem(DEFAULT_MOTION_PRO_CABLE_SPEEDO.toString())))
            .andExpect(jsonPath("$.[*].motionProCableThrottleTube").value(hasItem(DEFAULT_MOTION_PRO_CABLE_THROTTLE_TUBE.toString())))
            .andExpect(jsonPath("$.[*].crossproRadiatorGuard").value(hasItem(DEFAULT_CROSSPRO_RADIATOR_GUARD.toString())))
            .andExpect(jsonPath("$.[*].oemClutchFibres").value(hasItem(DEFAULT_OEM_CLUTCH_FIBRES.toString())))
            .andExpect(jsonPath("$.[*].oemClutchFibresSteels").value(hasItem(DEFAULT_OEM_CLUTCH_FIBRES_STEELS.toString())))
            .andExpect(jsonPath("$.[*].newfrenClutchKit").value(hasItem(DEFAULT_NEWFREN_CLUTCH_KIT.toString())))
            .andExpect(jsonPath("$.[*].newfrenClutchSpringKits").value(hasItem(DEFAULT_NEWFREN_CLUTCH_SPRING_KITS.toString())))
            .andExpect(jsonPath("$.[*].allBallsCMCRebuiltKit").value(hasItem(DEFAULT_ALL_BALLS_CMC_REBUILT_KIT.toString())))
            .andExpect(jsonPath("$.[*].wisecoForgedClutchBasket").value(hasItem(DEFAULT_WISECO_FORGED_CLUTCH_BASKET.toString())))
            .andExpect(jsonPath("$.[*].wisecoBottemEndRebuildKit").value(hasItem(DEFAULT_WISECO_BOTTEM_END_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].wrenchRERebuildKit").value(hasItem(DEFAULT_WRENCH_RE_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].oemCarbAssembly").value(hasItem(DEFAULT_OEM_CARB_ASSEMBLY.toString())))
            .andExpect(jsonPath("$.[*].allBallsCarbRepairKit").value(hasItem(DEFAULT_ALL_BALLS_CARB_REPAIR_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsCRMidBodyGasket1").value(hasItem(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_1.toString())))
            .andExpect(jsonPath("$.[*].allBallsCRMidBodyGasket2").value(hasItem(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_2.toString())))
            .andExpect(jsonPath("$.[*].allBallsFuelTapRepairKit").value(hasItem(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsFuelTapRepairKit2").value(hasItem(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2.toString())))
            .andExpect(jsonPath("$.[*].fuelStarFuelValveKit").value(hasItem(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT.toString())))
            .andExpect(jsonPath("$.[*].fuelStarFuelValveKit2").value(hasItem(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT_2.toString())))
            .andExpect(jsonPath("$.[*].fuelStarHoseClampKit").value(hasItem(DEFAULT_FUEL_STAR_HOSE_CLAMP_KIT.toString())))
            .andExpect(jsonPath("$.[*].rgEngineCoverLHS").value(hasItem(DEFAULT_RG_ENGINE_COVER_LHS.toString())))
            .andExpect(jsonPath("$.[*].rgTailTidy").value(hasItem(DEFAULT_RG_TAIL_TIDY.toString())))
            .andExpect(jsonPath("$.[*].allBallsLBSealKit").value(hasItem(DEFAULT_ALL_BALLS_LB_SEAL_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsLRSBearingKit").value(hasItem(DEFAULT_ALL_BALLS_LRS_BEARING_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsURSBearingKit").value(hasItem(DEFAULT_ALL_BALLS_URS_BEARING_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsULSBearingKit").value(hasItem(DEFAULT_ALL_BALLS_ULS_BEARING_KIT.toString())))
            .andExpect(jsonPath("$.[*].allBallsSBSealKit").value(hasItem(DEFAULT_ALL_BALLS_SB_SEAL_KIT.toString())))
            .andExpect(jsonPath("$.[*].pivotWorksSTBearingKit").value(hasItem(DEFAULT_PIVOT_WORKS_ST_BEARING_KIT.toString())))
            .andExpect(jsonPath("$.[*].pivotWorksSRebuildKit").value(hasItem(DEFAULT_PIVOT_WORKS_S_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].mpForkSealDriver").value(hasItem(DEFAULT_MP_FORK_SEAL_DRIVER.toString())))
            .andExpect(jsonPath("$.[*].mpValveSealInstallTool").value(hasItem(DEFAULT_MP_VALVE_SEAL_INSTALL_TOOL.toString())))
            .andExpect(jsonPath("$.[*].winderosaGasketKitTopEnd").value(hasItem(DEFAULT_WINDEROSA_GASKET_KIT_TOP_END.toString())))
            .andExpect(jsonPath("$.[*].winderosaGasketKitOilSeals").value(hasItem(DEFAULT_WINDEROSA_GASKET_KIT_OIL_SEALS.toString())))
            .andExpect(jsonPath("$.[*].oemExhaustGasket").value(hasItem(DEFAULT_OEM_EXHAUST_GASKET.toString())))
            .andExpect(jsonPath("$.[*].winderosaGasketExhaust").value(hasItem(DEFAULT_WINDEROSA_GASKET_EXHAUST.toString())))
            .andExpect(jsonPath("$.[*].winderosaWaterPumpRebuildKit").value(hasItem(DEFAULT_WINDEROSA_WATER_PUMP_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].hotRodsConnectingRodKit").value(hasItem(DEFAULT_HOT_RODS_CONNECTING_ROD_KIT.toString())))
            .andExpect(jsonPath("$.[*].hotRodsCounterBalRebuildKit").value(hasItem(DEFAULT_HOT_RODS_COUNTER_BAL_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].hotRodsBERebuildKit").value(hasItem(DEFAULT_HOT_RODS_BE_REBUILD_KIT.toString())))
            .andExpect(jsonPath("$.[*].hotRodsBERebuildKitSt").value(hasItem(DEFAULT_HOT_RODS_BE_REBUILD_KIT_ST.toString())))
            .andExpect(jsonPath("$.[*].hotRodsCylinderHead").value(hasItem(DEFAULT_HOT_RODS_CYLINDER_HEAD.toString())))
            .andExpect(jsonPath("$.[*].hotRodsMainBearingSealKit").value(hasItem(DEFAULT_HOT_RODS_MAIN_BEARING_SEAL_KIT.toString())))
            .andExpect(jsonPath("$.[*].hotRodsTransmissionBearings").value(hasItem(DEFAULT_HOT_RODS_TRANSMISSION_BEARINGS.toString())))
            .andExpect(jsonPath("$.[*].hotRodsWristPinBearings").value(hasItem(DEFAULT_HOT_RODS_WRIST_PIN_BEARINGS.toString())))
            .andExpect(jsonPath("$.[*].hotRodsSOHCCamshaftStage1").value(hasItem(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_1.toString())))
            .andExpect(jsonPath("$.[*].hotRodsSOHCCamshaftStage2").value(hasItem(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_2.toString())))
            .andExpect(jsonPath("$.[*].hotRodsSOHCCamshaftStage3").value(hasItem(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_3.toString())))
            .andExpect(jsonPath("$.[*].hotRodsDOHCCamshaftStage1Intake").value(hasItem(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE.toString())))
            .andExpect(jsonPath("$.[*].hotRodsDOHCCamshaftStage1Exhaust").value(hasItem(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST.toString())))
            .andExpect(jsonPath("$.[*].hotRodsDOHCCamshaftStage2Intake").value(hasItem(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE.toString())))
            .andExpect(jsonPath("$.[*].hotRodsDOHCCamshaftStage2Exhaust").value(hasItem(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST.toString())));
    }
    
    public void getAllBikesWithEagerRelationshipsIsEnabled() throws Exception {
        BikeResource bikeResource = new BikeResource(bikeServiceMock);
        when(bikeServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));

        MockMvc restBikeMockMvc = MockMvcBuilders.standaloneSetup(bikeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();

        restBikeMockMvc.perform(get("/api/bikes?eagerload=true"))
        .andExpect(status().isOk());

        verify(bikeServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    public void getAllBikesWithEagerRelationshipsIsNotEnabled() throws Exception {
        BikeResource bikeResource = new BikeResource(bikeServiceMock);
            when(bikeServiceMock.findAllWithEagerRelationships(any())).thenReturn(new PageImpl(new ArrayList<>()));
            MockMvc restBikeMockMvc = MockMvcBuilders.standaloneSetup(bikeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();

        restBikeMockMvc.perform(get("/api/bikes?eagerload=true"))
        .andExpect(status().isOk());

            verify(bikeServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    @Transactional
    public void getBike() throws Exception {
        // Initialize the database
        bikeRepository.saveAndFlush(bike);

        // Get the bike
        restBikeMockMvc.perform(get("/api/bikes/{id}", bike.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(bike.getId().intValue()))
            .andExpect(jsonPath("$.visibilityAU").value(DEFAULT_VISIBILITY_AU.toString()))
            .andExpect(jsonPath("$.visibilityEU").value(DEFAULT_VISIBILITY_EU.toString()))
            .andExpect(jsonPath("$.inactive").value(DEFAULT_INACTIVE.toString()))
            .andExpect(jsonPath("$.oemconfirmed").value(DEFAULT_OEMCONFIRMED.toString()))
            .andExpect(jsonPath("$.oesource").value(DEFAULT_OESOURCE.toString()))
            .andExpect(jsonPath("$.epid").value(DEFAULT_EPID.intValue()))
            .andExpect(jsonPath("$.modeltype1").value(DEFAULT_MODELTYPE_1.toString()))
            .andExpect(jsonPath("$.modeltype2").value(DEFAULT_MODELTYPE_2.toString()))
            .andExpect(jsonPath("$.manufacturer").value(DEFAULT_MANUFACTURER.toString()))
            .andExpect(jsonPath("$.strokes").value(DEFAULT_STROKES.toString()))
            .andExpect(jsonPath("$.capacity").value(DEFAULT_CAPACITY.intValue()))
            .andExpect(jsonPath("$.modelName").value(DEFAULT_MODEL_NAME.toString()))
            .andExpect(jsonPath("$.modelYearCode").value(DEFAULT_MODEL_YEAR_CODE.toString()))
            .andExpect(jsonPath("$.modelTypeCode").value(DEFAULT_MODEL_TYPE_CODE.toString()))
            .andExpect(jsonPath("$.year").value(DEFAULT_YEAR.intValue()))
            .andExpect(jsonPath("$.finalDriveType").value(DEFAULT_FINAL_DRIVE_TYPE.toString()))
            .andExpect(jsonPath("$.categoryPath").value(DEFAULT_CATEGORY_PATH.toString()))
            .andExpect(jsonPath("$.modelNotes").value(DEFAULT_MODEL_NOTES.toString()))
            .andExpect(jsonPath("$.modelNotes2").value(DEFAULT_MODEL_NOTES_2.toString()))
            .andExpect(jsonPath("$.modelNotes3").value(DEFAULT_MODEL_NOTES_3.toString()))
            .andExpect(jsonPath("$.modelNotes4").value(DEFAULT_MODEL_NOTES_4.toString()))
            .andExpect(jsonPath("$.modelInfoHTML").value(DEFAULT_MODEL_INFO_HTML.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeSystemType").value(DEFAULT_OEM_FRONT_BRAKE_SYSTEM_TYPE.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeDiscLeft").value(DEFAULT_OEM_FRONT_BRAKE_DISC_LEFT.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeDiscRight").value(DEFAULT_OEM_FRONT_BRAKE_DISC_RIGHT.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeDiscBolts").value(DEFAULT_OEM_FRONT_BRAKE_DISC_BOLTS.toString()))
            .andExpect(jsonPath("$.oemFrontBDQTYPD").value(DEFAULT_OEM_FRONT_BDQTYPD.intValue()))
            .andExpect(jsonPath("$.oemFrontBrakeDiscABSRing").value(DEFAULT_OEM_FRONT_BRAKE_DISC_ABS_RING.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeCaliper1").value(DEFAULT_OEM_FRONT_BRAKE_CALIPER_1.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeCaliper2").value(DEFAULT_OEM_FRONT_BRAKE_CALIPER_2.toString()))
            .andExpect(jsonPath("$.oemFrontBrakeCaliperPin").value(DEFAULT_OEM_FRONT_BRAKE_CALIPER_PIN.toString()))
            .andExpect(jsonPath("$.oemFrontBrakePadsFrontL").value(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_L.toString()))
            .andExpect(jsonPath("$.oemFrontBrakePadsFrontR").value(DEFAULT_OEM_FRONT_BRAKE_PADS_FRONT_R.toString()))
            .andExpect(jsonPath("$.oemFrontShoe").value(DEFAULT_OEM_FRONT_SHOE.toString()))
            .andExpect(jsonPath("$.oemMidldleAxleBrakeDisc").value(DEFAULT_OEM_MIDLDLE_AXLE_BRAKE_DISC.toString()))
            .andExpect(jsonPath("$.oemMiddleAxleBrakePads").value(DEFAULT_OEM_MIDDLE_AXLE_BRAKE_PADS.toString()))
            .andExpect(jsonPath("$.oemRearBrakeSystemType").value(DEFAULT_OEM_REAR_BRAKE_SYSTEM_TYPE.toString()))
            .andExpect(jsonPath("$.oeamRearBrakeDisc").value(DEFAULT_OEAM_REAR_BRAKE_DISC.toString()))
            .andExpect(jsonPath("$.oeamRearBrakeDiscBolts").value(DEFAULT_OEAM_REAR_BRAKE_DISC_BOLTS.toString()))
            .andExpect(jsonPath("$.oeamRearBrakeDiscBQTYPD").value(DEFAULT_OEAM_REAR_BRAKE_DISC_BQTYPD.intValue()))
            .andExpect(jsonPath("$.oemRearBrakeCaliper").value(DEFAULT_OEM_REAR_BRAKE_CALIPER.toString()))
            .andExpect(jsonPath("$.oemRearBrakeCaliperPin").value(DEFAULT_OEM_REAR_BRAKE_CALIPER_PIN.toString()))
            .andExpect(jsonPath("$.oemRearBrakePads1").value(DEFAULT_OEM_REAR_BRAKE_PADS_1.toString()))
            .andExpect(jsonPath("$.oemRearBrakePads2").value(DEFAULT_OEM_REAR_BRAKE_PADS_2.toString()))
            .andExpect(jsonPath("$.oemShoeRear").value(DEFAULT_OEM_SHOE_REAR.toString()))
            .andExpect(jsonPath("$.oemShoeRear2").value(DEFAULT_OEM_SHOE_REAR_2.toString()))
            .andExpect(jsonPath("$.oemSlaveCylinder").value(DEFAULT_OEM_SLAVE_CYLINDER.toString()))
            .andExpect(jsonPath("$.oemChainNo").value(DEFAULT_OEM_CHAIN_NO.toString()))
            .andExpect(jsonPath("$.oemChainSize").value(DEFAULT_OEM_CHAIN_SIZE.intValue()))
            .andExpect(jsonPath("$.oemChainLinks").value(DEFAULT_OEM_CHAIN_LINKS.intValue()))
            .andExpect(jsonPath("$.oemFrontSprocket").value(DEFAULT_OEM_FRONT_SPROCKET.toString()))
            .andExpect(jsonPath("$.oemFrontGearing").value(DEFAULT_OEM_FRONT_GEARING.intValue()))
            .andExpect(jsonPath("$.oemFrontGearingMin").value(DEFAULT_OEM_FRONT_GEARING_MIN.intValue()))
            .andExpect(jsonPath("$.oemFrontGearingMax").value(DEFAULT_OEM_FRONT_GEARING_MAX.intValue()))
            .andExpect(jsonPath("$.oemRearSprocket").value(DEFAULT_OEM_REAR_SPROCKET.toString()))
            .andExpect(jsonPath("$.oemRearGearing").value(DEFAULT_OEM_REAR_GEARING.intValue()))
            .andExpect(jsonPath("$.oemRearGearingMin").value(DEFAULT_OEM_REAR_GEARING_MIN.intValue()))
            .andExpect(jsonPath("$.oemRearGearingMax").value(DEFAULT_OEM_REAR_GEARING_MAX.intValue()))
            .andExpect(jsonPath("$.finalDriveNotes").value(DEFAULT_FINAL_DRIVE_NOTES.toString()))
            .andExpect(jsonPath("$.chainConvSize").value(DEFAULT_CHAIN_CONV_SIZE.intValue()))
            .andExpect(jsonPath("$.chainConvLinks").value(DEFAULT_CHAIN_CONV_LINKS.intValue()))
            .andExpect(jsonPath("$.oemFrontWheel").value(DEFAULT_OEM_FRONT_WHEEL.toString()))
            .andExpect(jsonPath("$.oemFrontWheelType").value(DEFAULT_OEM_FRONT_WHEEL_TYPE.toString()))
            .andExpect(jsonPath("$.oemFrontWheelFront").value(DEFAULT_OEM_FRONT_WHEEL_FRONT.intValue()))
            .andExpect(jsonPath("$.oemFrontWheelTyreSize").value(DEFAULT_OEM_FRONT_WHEEL_TYRE_SIZE.toString()))
            .andExpect(jsonPath("$.oemFrontHub").value(DEFAULT_OEM_FRONT_HUB.toString()))
            .andExpect(jsonPath("$.oemFrontWheelbearing1").value(DEFAULT_OEM_FRONT_WHEELBEARING_1.toString()))
            .andExpect(jsonPath("$.oemFrontWheelbearing2").value(DEFAULT_OEM_FRONT_WHEELBEARING_2.toString()))
            .andExpect(jsonPath("$.oemFrontWheelSeal").value(DEFAULT_OEM_FRONT_WHEEL_SEAL.toString()))
            .andExpect(jsonPath("$.oemRearWheel").value(DEFAULT_OEM_REAR_WHEEL.toString()))
            .andExpect(jsonPath("$.oemRearWheelSize").value(DEFAULT_OEM_REAR_WHEEL_SIZE.intValue()))
            .andExpect(jsonPath("$.oemRearWheelTyre").value(DEFAULT_OEM_REAR_WHEEL_TYRE.toString()))
            .andExpect(jsonPath("$.oemRearWheelBearing1").value(DEFAULT_OEM_REAR_WHEEL_BEARING_1.toString()))
            .andExpect(jsonPath("$.oemRearWheelBearing2").value(DEFAULT_OEM_REAR_WHEEL_BEARING_2.toString()))
            .andExpect(jsonPath("$.oemRearWheelSeal").value(DEFAULT_OEM_REAR_WHEEL_SEAL.toString()))
            .andExpect(jsonPath("$.frontPadsDiffCaliper").value(DEFAULT_FRONT_PADS_DIFF_CALIPER.toString()))
            .andExpect(jsonPath("$.qtyBH").value(DEFAULT_QTY_BH.intValue()))
            .andExpect(jsonPath("$.handbrakeParking").value(DEFAULT_HANDBRAKE_PARKING.toString()))
            .andExpect(jsonPath("$.addNotesToBike").value(DEFAULT_ADD_NOTES_TO_BIKE.toString()))
            .andExpect(jsonPath("$.dateAndID").value(DEFAULT_DATE_AND_ID.toString()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE.toString()))
            .andExpect(jsonPath("$.tuvRequired").value(DEFAULT_TUV_REQUIRED.toString()))
            .andExpect(jsonPath("$.tuvTypeCode").value(DEFAULT_TUV_TYPE_CODE.toString()))
            .andExpect(jsonPath("$.abekba").value(DEFAULT_ABEKBA.toString()))
            .andExpect(jsonPath("$.tuvFrontDisc").value(DEFAULT_TUV_FRONT_DISC.toString()))
            .andExpect(jsonPath("$.tuvRearDisc").value(DEFAULT_TUV_REAR_DISC.toString()))
            .andExpect(jsonPath("$.bremboBrakeDiscFrontRef").value(DEFAULT_BREMBO_BRAKE_DISC_FRONT_REF.toString()))
            .andExpect(jsonPath("$.ebcBrakeDiscFrontRef").value(DEFAULT_EBC_BRAKE_DISC_FRONT_REF.toString()))
            .andExpect(jsonPath("$.trwBrakeDiscFrontRef").value(DEFAULT_TRW_BRAKE_DISC_FRONT_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFrontLeftRef").value(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFrontRightRef").value(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFrontCheck").value(DEFAULT_MGEAR_BRAKE_DISC_FRONT_CHECK.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFrontLeftRef2").value(DEFAULT_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFrontRightRef2").value(DEFAULT_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscFNeto").value(DEFAULT_MGEAR_BRAKE_DISC_F_NETO.toString()))
            .andExpect(jsonPath("$.motodiscBrakeDiscFNeto").value(DEFAULT_MOTODISC_BRAKE_DISC_F_NETO.toString()))
            .andExpect(jsonPath("$.ebcBrakePadsFrontLRef").value(DEFAULT_EBC_BRAKE_PADS_FRONT_L_REF.toString()))
            .andExpect(jsonPath("$.ebcBrakePadsFrontRRef").value(DEFAULT_EBC_BRAKE_PADS_FRONT_R_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsFrontLRef").value(DEFAULT_MGEAR_BRAKE_PADS_FRONT_L_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsFrontRRef").value(DEFAULT_MGEAR_BRAKE_PADS_FRONT_R_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsFNeto").value(DEFAULT_MGEAR_BRAKE_PADS_F_NETO.toString()))
            .andExpect(jsonPath("$.motoPadBrakePadsFrontLRef").value(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_L_REF.toString()))
            .andExpect(jsonPath("$.motoPadBrakePadsFrontRRef").value(DEFAULT_MOTO_PAD_BRAKE_PADS_FRONT_R_REF.toString()))
            .andExpect(jsonPath("$.motopadBrakePadsFNeto").value(DEFAULT_MOTOPAD_BRAKE_PADS_F_NETO.toString()))
            .andExpect(jsonPath("$.allBallsFCRebuildKit1").value(DEFAULT_ALL_BALLS_FC_REBUILD_KIT_1.toString()))
            .andExpect(jsonPath("$.allBallsFCPin").value(DEFAULT_ALL_BALLS_FC_PIN.toString()))
            .andExpect(jsonPath("$.allBallsFMCyRebuildKit").value(DEFAULT_ALL_BALLS_FM_CY_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.allBallsFSCRebuildKit").value(DEFAULT_ALL_BALLS_FSC_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.newfrenShoeFront").value(DEFAULT_NEWFREN_SHOE_FRONT.toString()))
            .andExpect(jsonPath("$.mgearMiddleAxleBrakeDiscNeto").value(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO.toString()))
            .andExpect(jsonPath("$.mgearMiddleAxleBrakeDiscNeto2").value(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2.toString()))
            .andExpect(jsonPath("$.mgearMiddleAxleBrakePadNeto").value(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO.toString()))
            .andExpect(jsonPath("$.mgearMiddleAxleBrakePadNeto2").value(DEFAULT_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsParkRef").value(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsParkRef2").value(DEFAULT_MGEAR_BRAKE_PADS_PARK_REF_2.toString()))
            .andExpect(jsonPath("$.ebcBrakeDiscRearRef").value(DEFAULT_EBC_BRAKE_DISC_REAR_REF.toString()))
            .andExpect(jsonPath("$.bremboBrakeDiscRearRef").value(DEFAULT_BREMBO_BRAKE_DISC_REAR_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscRearRef").value(DEFAULT_MGEAR_BRAKE_DISC_REAR_REF.toString()))
            .andExpect(jsonPath("$.trwBrakeDiscRearRef").value(DEFAULT_TRW_BRAKE_DISC_REAR_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakeDiscRear").value(DEFAULT_MGEAR_BRAKE_DISC_REAR.toString()))
            .andExpect(jsonPath("$.allBallsRCRebuildKit1").value(DEFAULT_ALL_BALLS_RC_REBUILD_KIT_1.toString()))
            .andExpect(jsonPath("$.allBallsRearCaliperBolt").value(DEFAULT_ALL_BALLS_REAR_CALIPER_BOLT.toString()))
            .andExpect(jsonPath("$.allBallsRMCrRebuildKit").value(DEFAULT_ALL_BALLS_RM_CR_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.ebcBrakePadsRearRef").value(DEFAULT_EBC_BRAKE_PADS_REAR_REF.toString()))
            .andExpect(jsonPath("$.mgearBrakePadsRearNeto").value(DEFAULT_MGEAR_BRAKE_PADS_REAR_NETO.toString()))
            .andExpect(jsonPath("$.newfrenShoeRear").value(DEFAULT_NEWFREN_SHOE_REAR.toString()))
            .andExpect(jsonPath("$.allBallsRearBrakePedalKit").value(DEFAULT_ALL_BALLS_REAR_BRAKE_PEDAL_KIT.toString()))
            .andExpect(jsonPath("$.allBallsCSCRebuildKit").value(DEFAULT_ALL_BALLS_CSC_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.frontJTRefFront").value(DEFAULT_FRONT_JT_REF_FRONT.toString()))
            .andExpect(jsonPath("$.esjotRefFront").value(DEFAULT_ESJOT_REF_FRONT.toString()))
            .andExpect(jsonPath("$.mgearRefFront").value(DEFAULT_MGEAR_REF_FRONT.toString()))
            .andExpect(jsonPath("$.mogemaRefFront").value(DEFAULT_MOGEMA_REF_FRONT.toString()))
            .andExpect(jsonPath("$.supersproxRefFront").value(DEFAULT_SUPERSPROX_REF_FRONT.toString()))
            .andExpect(jsonPath("$.esjotRefRear").value(DEFAULT_ESJOT_REF_REAR.toString()))
            .andExpect(jsonPath("$.jtRefRear").value(DEFAULT_JT_REF_REAR.toString()))
            .andExpect(jsonPath("$.mgearRefRear").value(DEFAULT_MGEAR_REF_REAR.toString()))
            .andExpect(jsonPath("$.mogemaRefRear").value(DEFAULT_MOGEMA_REF_REAR.toString()))
            .andExpect(jsonPath("$.supersproxRefRear").value(DEFAULT_SUPERSPROX_REF_REAR.toString()))
            .andExpect(jsonPath("$.esjotRefFrontConv").value(DEFAULT_ESJOT_REF_FRONT_CONV.toString()))
            .andExpect(jsonPath("$.jtSprocketRef").value(DEFAULT_JT_SPROCKET_REF.toString()))
            .andExpect(jsonPath("$.mgearRefFrontConv").value(DEFAULT_MGEAR_REF_FRONT_CONV.toString()))
            .andExpect(jsonPath("$.mogemarefFrontConv").value(DEFAULT_MOGEMAREF_FRONT_CONV.toString()))
            .andExpect(jsonPath("$.supersproxRefFrontConv").value(DEFAULT_SUPERSPROX_REF_FRONT_CONV.toString()))
            .andExpect(jsonPath("$.conversionChain").value(DEFAULT_CONVERSION_CHAIN.toString()))
            .andExpect(jsonPath("$.mgearSprocketRearConv").value(DEFAULT_MGEAR_SPROCKET_REAR_CONV.toString()))
            .andExpect(jsonPath("$.esjotRefRearConv").value(DEFAULT_ESJOT_REF_REAR_CONV.toString()))
            .andExpect(jsonPath("$.mgearRefRearConv").value(DEFAULT_MGEAR_REF_REAR_CONV.toString()))
            .andExpect(jsonPath("$.mogemaRefRearConv").value(DEFAULT_MOGEMA_REF_REAR_CONV.toString()))
            .andExpect(jsonPath("$.supersproxRefRearConv").value(DEFAULT_SUPERSPROX_REF_REAR_CONV.toString()))
            .andExpect(jsonPath("$.allBallsFWBearingKit1").value(DEFAULT_ALL_BALLS_FW_BEARING_KIT_1.toString()))
            .andExpect(jsonPath("$.allBallsFWBearingKit2").value(DEFAULT_ALL_BALLS_FW_BEARING_KIT_2.toString()))
            .andExpect(jsonPath("$.allBallsRWBearingKit1").value(DEFAULT_ALL_BALLS_RW_BEARING_KIT_1.toString()))
            .andExpect(jsonPath("$.allBallsRWBearingKit2").value(DEFAULT_ALL_BALLS_RW_BEARING_KIT_2.toString()))
            .andExpect(jsonPath("$.allBallsRWBearingUpgrade").value(DEFAULT_ALL_BALLS_RW_BEARING_UPGRADE.toString()))
            .andExpect(jsonPath("$.oemSparkPlug").value(DEFAULT_OEM_SPARK_PLUG.toString()))
            .andExpect(jsonPath("$.oemSparkPlugQTY").value(DEFAULT_OEM_SPARK_PLUG_QTY.intValue()))
            .andExpect(jsonPath("$.ngkSparkPlugSKUs").value(DEFAULT_NGK_SPARK_PLUG_SK_US.toString()))
            .andExpect(jsonPath("$.oemAlternator").value(DEFAULT_OEM_ALTERNATOR.toString()))
            .andExpect(jsonPath("$.oemVoltageRegulator").value(DEFAULT_OEM_VOLTAGE_REGULATOR.toString()))
            .andExpect(jsonPath("$.arrowheadAlternator").value(DEFAULT_ARROWHEAD_ALTERNATOR.toString()))
            .andExpect(jsonPath("$.arrowheadAlternator2").value(DEFAULT_ARROWHEAD_ALTERNATOR_2.toString()))
            .andExpect(jsonPath("$.arrowheadCDIModule").value(DEFAULT_ARROWHEAD_CDI_MODULE.toString()))
            .andExpect(jsonPath("$.arrowheadChargingCoil").value(DEFAULT_ARROWHEAD_CHARGING_COIL.toString()))
            .andExpect(jsonPath("$.arrowheadIgnitionCoil").value(DEFAULT_ARROWHEAD_IGNITION_COIL.toString()))
            .andExpect(jsonPath("$.arrowheadStatorCoil").value(DEFAULT_ARROWHEAD_STATOR_COIL.toString()))
            .andExpect(jsonPath("$.arrowheadVoltageRegulator").value(DEFAULT_ARROWHEAD_VOLTAGE_REGULATOR.toString()))
            .andExpect(jsonPath("$.arrowheadPowerShiftCM").value(DEFAULT_ARROWHEAD_POWER_SHIFT_CM.toString()))
            .andExpect(jsonPath("$.arrowheadStarterDrive").value(DEFAULT_ARROWHEAD_STARTER_DRIVE.toString()))
            .andExpect(jsonPath("$.arrowheadStarterMotor").value(DEFAULT_ARROWHEAD_STARTER_MOTOR.toString()))
            .andExpect(jsonPath("$.arrowheadStarterRelay").value(DEFAULT_ARROWHEAD_STARTER_RELAY.toString()))
            .andExpect(jsonPath("$.oemBattery").value(DEFAULT_OEM_BATTERY.toString()))
            .andExpect(jsonPath("$.ssbAGMBattery").value(DEFAULT_SSB_AGM_BATTERY.toString()))
            .andExpect(jsonPath("$.oemAirFilter").value(DEFAULT_OEM_AIR_FILTER.toString()))
            .andExpect(jsonPath("$.knAirFilter").value(DEFAULT_KN_AIR_FILTER.toString()))
            .andExpect(jsonPath("$.motorexAirFilter").value(DEFAULT_MOTOREX_AIR_FILTER.toString()))
            .andExpect(jsonPath("$.motorexAirFilterPreoiled").value(DEFAULT_MOTOREX_AIR_FILTER_PREOILED.toString()))
            .andExpect(jsonPath("$.oemOilFilter1").value(DEFAULT_OEM_OIL_FILTER_1.toString()))
            .andExpect(jsonPath("$.knOilFilter1").value(DEFAULT_KN_OIL_FILTER_1.toString()))
            .andExpect(jsonPath("$.oemOilFilter2").value(DEFAULT_OEM_OIL_FILTER_2.toString()))
            .andExpect(jsonPath("$.knOilFilter2").value(DEFAULT_KN_OIL_FILTER_2.toString()))
            .andExpect(jsonPath("$.motionProOilFilterMagnet").value(DEFAULT_MOTION_PRO_OIL_FILTER_MAGNET.toString()))
            .andExpect(jsonPath("$.oemSteeringBearing").value(DEFAULT_OEM_STEERING_BEARING.toString()))
            .andExpect(jsonPath("$.oemSteeringSeal").value(DEFAULT_OEM_STEERING_SEAL.toString()))
            .andExpect(jsonPath("$.allBallsSBSealKit1").value(DEFAULT_ALL_BALLS_SB_SEAL_KIT_1.toString()))
            .andExpect(jsonPath("$.allBallsSBSealKit2").value(DEFAULT_ALL_BALLS_SB_SEAL_KIT_2.toString()))
            .andExpect(jsonPath("$.allBallsSBSealKitLower").value(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER.toString()))
            .andExpect(jsonPath("$.allBallsSBSealKitLower2").value(DEFAULT_ALL_BALLS_SB_SEAL_KIT_LOWER_2.toString()))
            .andExpect(jsonPath("$.allBallsCBSealKit").value(DEFAULT_ALL_BALLS_CB_SEAL_KIT.toString()))
            .andExpect(jsonPath("$.oemForkAssemblyLeft").value(DEFAULT_OEM_FORK_ASSEMBLY_LEFT.toString()))
            .andExpect(jsonPath("$.oemForkAssemblyRight").value(DEFAULT_OEM_FORK_ASSEMBLY_RIGHT.toString()))
            .andExpect(jsonPath("$.oemForkSeals").value(DEFAULT_OEM_FORK_SEALS.toString()))
            .andExpect(jsonPath("$.allBallsForkSeals").value(DEFAULT_ALL_BALLS_FORK_SEALS.toString()))
            .andExpect(jsonPath("$.xprForkSeals").value(DEFAULT_XPR_FORK_SEALS.toString()))
            .andExpect(jsonPath("$.allBallsForkBushingKit").value(DEFAULT_ALL_BALLS_FORK_BUSHING_KIT.toString()))
            .andExpect(jsonPath("$.motionProMicroForkBleeder").value(DEFAULT_MOTION_PRO_MICRO_FORK_BLEEDER.toString()))
            .andExpect(jsonPath("$.motionProCRProThottleKit").value(DEFAULT_MOTION_PRO_CR_PRO_THOTTLE_KIT.toString()))
            .andExpect(jsonPath("$.oemCableSpeedo").value(DEFAULT_OEM_CABLE_SPEEDO.toString()))
            .andExpect(jsonPath("$.motionProCableSpeedo").value(DEFAULT_MOTION_PRO_CABLE_SPEEDO.toString()))
            .andExpect(jsonPath("$.motionProCableThrottleTube").value(DEFAULT_MOTION_PRO_CABLE_THROTTLE_TUBE.toString()))
            .andExpect(jsonPath("$.crossproRadiatorGuard").value(DEFAULT_CROSSPRO_RADIATOR_GUARD.toString()))
            .andExpect(jsonPath("$.oemClutchFibres").value(DEFAULT_OEM_CLUTCH_FIBRES.toString()))
            .andExpect(jsonPath("$.oemClutchFibresSteels").value(DEFAULT_OEM_CLUTCH_FIBRES_STEELS.toString()))
            .andExpect(jsonPath("$.newfrenClutchKit").value(DEFAULT_NEWFREN_CLUTCH_KIT.toString()))
            .andExpect(jsonPath("$.newfrenClutchSpringKits").value(DEFAULT_NEWFREN_CLUTCH_SPRING_KITS.toString()))
            .andExpect(jsonPath("$.allBallsCMCRebuiltKit").value(DEFAULT_ALL_BALLS_CMC_REBUILT_KIT.toString()))
            .andExpect(jsonPath("$.wisecoForgedClutchBasket").value(DEFAULT_WISECO_FORGED_CLUTCH_BASKET.toString()))
            .andExpect(jsonPath("$.wisecoBottemEndRebuildKit").value(DEFAULT_WISECO_BOTTEM_END_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.wrenchRERebuildKit").value(DEFAULT_WRENCH_RE_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.oemCarbAssembly").value(DEFAULT_OEM_CARB_ASSEMBLY.toString()))
            .andExpect(jsonPath("$.allBallsCarbRepairKit").value(DEFAULT_ALL_BALLS_CARB_REPAIR_KIT.toString()))
            .andExpect(jsonPath("$.allBallsCRMidBodyGasket1").value(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_1.toString()))
            .andExpect(jsonPath("$.allBallsCRMidBodyGasket2").value(DEFAULT_ALL_BALLS_CR_MID_BODY_GASKET_2.toString()))
            .andExpect(jsonPath("$.allBallsFuelTapRepairKit").value(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT.toString()))
            .andExpect(jsonPath("$.allBallsFuelTapRepairKit2").value(DEFAULT_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2.toString()))
            .andExpect(jsonPath("$.fuelStarFuelValveKit").value(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT.toString()))
            .andExpect(jsonPath("$.fuelStarFuelValveKit2").value(DEFAULT_FUEL_STAR_FUEL_VALVE_KIT_2.toString()))
            .andExpect(jsonPath("$.fuelStarHoseClampKit").value(DEFAULT_FUEL_STAR_HOSE_CLAMP_KIT.toString()))
            .andExpect(jsonPath("$.rgEngineCoverLHS").value(DEFAULT_RG_ENGINE_COVER_LHS.toString()))
            .andExpect(jsonPath("$.rgTailTidy").value(DEFAULT_RG_TAIL_TIDY.toString()))
            .andExpect(jsonPath("$.allBallsLBSealKit").value(DEFAULT_ALL_BALLS_LB_SEAL_KIT.toString()))
            .andExpect(jsonPath("$.allBallsLRSBearingKit").value(DEFAULT_ALL_BALLS_LRS_BEARING_KIT.toString()))
            .andExpect(jsonPath("$.allBallsURSBearingKit").value(DEFAULT_ALL_BALLS_URS_BEARING_KIT.toString()))
            .andExpect(jsonPath("$.allBallsULSBearingKit").value(DEFAULT_ALL_BALLS_ULS_BEARING_KIT.toString()))
            .andExpect(jsonPath("$.allBallsSBSealKit").value(DEFAULT_ALL_BALLS_SB_SEAL_KIT.toString()))
            .andExpect(jsonPath("$.pivotWorksSTBearingKit").value(DEFAULT_PIVOT_WORKS_ST_BEARING_KIT.toString()))
            .andExpect(jsonPath("$.pivotWorksSRebuildKit").value(DEFAULT_PIVOT_WORKS_S_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.mpForkSealDriver").value(DEFAULT_MP_FORK_SEAL_DRIVER.toString()))
            .andExpect(jsonPath("$.mpValveSealInstallTool").value(DEFAULT_MP_VALVE_SEAL_INSTALL_TOOL.toString()))
            .andExpect(jsonPath("$.winderosaGasketKitTopEnd").value(DEFAULT_WINDEROSA_GASKET_KIT_TOP_END.toString()))
            .andExpect(jsonPath("$.winderosaGasketKitOilSeals").value(DEFAULT_WINDEROSA_GASKET_KIT_OIL_SEALS.toString()))
            .andExpect(jsonPath("$.oemExhaustGasket").value(DEFAULT_OEM_EXHAUST_GASKET.toString()))
            .andExpect(jsonPath("$.winderosaGasketExhaust").value(DEFAULT_WINDEROSA_GASKET_EXHAUST.toString()))
            .andExpect(jsonPath("$.winderosaWaterPumpRebuildKit").value(DEFAULT_WINDEROSA_WATER_PUMP_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.hotRodsConnectingRodKit").value(DEFAULT_HOT_RODS_CONNECTING_ROD_KIT.toString()))
            .andExpect(jsonPath("$.hotRodsCounterBalRebuildKit").value(DEFAULT_HOT_RODS_COUNTER_BAL_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.hotRodsBERebuildKit").value(DEFAULT_HOT_RODS_BE_REBUILD_KIT.toString()))
            .andExpect(jsonPath("$.hotRodsBERebuildKitSt").value(DEFAULT_HOT_RODS_BE_REBUILD_KIT_ST.toString()))
            .andExpect(jsonPath("$.hotRodsCylinderHead").value(DEFAULT_HOT_RODS_CYLINDER_HEAD.toString()))
            .andExpect(jsonPath("$.hotRodsMainBearingSealKit").value(DEFAULT_HOT_RODS_MAIN_BEARING_SEAL_KIT.toString()))
            .andExpect(jsonPath("$.hotRodsTransmissionBearings").value(DEFAULT_HOT_RODS_TRANSMISSION_BEARINGS.toString()))
            .andExpect(jsonPath("$.hotRodsWristPinBearings").value(DEFAULT_HOT_RODS_WRIST_PIN_BEARINGS.toString()))
            .andExpect(jsonPath("$.hotRodsSOHCCamshaftStage1").value(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_1.toString()))
            .andExpect(jsonPath("$.hotRodsSOHCCamshaftStage2").value(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_2.toString()))
            .andExpect(jsonPath("$.hotRodsSOHCCamshaftStage3").value(DEFAULT_HOT_RODS_SOHC_CAMSHAFT_STAGE_3.toString()))
            .andExpect(jsonPath("$.hotRodsDOHCCamshaftStage1Intake").value(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE.toString()))
            .andExpect(jsonPath("$.hotRodsDOHCCamshaftStage1Exhaust").value(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST.toString()))
            .andExpect(jsonPath("$.hotRodsDOHCCamshaftStage2Intake").value(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE.toString()))
            .andExpect(jsonPath("$.hotRodsDOHCCamshaftStage2Exhaust").value(DEFAULT_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingBike() throws Exception {
        // Get the bike
        restBikeMockMvc.perform(get("/api/bikes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBike() throws Exception {
        // Initialize the database
        bikeRepository.saveAndFlush(bike);

        int databaseSizeBeforeUpdate = bikeRepository.findAll().size();

        // Update the bike
        Bike updatedBike = bikeRepository.findById(bike.getId()).get();
        // Disconnect from session so that the updates on updatedBike are not directly saved in db
        em.detach(updatedBike);
        updatedBike
            .visibilityAU(UPDATED_VISIBILITY_AU)
            .visibilityEU(UPDATED_VISIBILITY_EU)
            .inactive(UPDATED_INACTIVE)
            .oemconfirmed(UPDATED_OEMCONFIRMED)
            .oesource(UPDATED_OESOURCE)
            .epid(UPDATED_EPID)
            .modeltype1(UPDATED_MODELTYPE_1)
            .modeltype2(UPDATED_MODELTYPE_2)
            .manufacturer(UPDATED_MANUFACTURER)
            .strokes(UPDATED_STROKES)
            .capacity(UPDATED_CAPACITY)
            .modelName(UPDATED_MODEL_NAME)
            .modelYearCode(UPDATED_MODEL_YEAR_CODE)
            .modelTypeCode(UPDATED_MODEL_TYPE_CODE)
            .year(UPDATED_YEAR)
            .finalDriveType(UPDATED_FINAL_DRIVE_TYPE)
            .categoryPath(UPDATED_CATEGORY_PATH)
            .modelNotes(UPDATED_MODEL_NOTES)
            .modelNotes2(UPDATED_MODEL_NOTES_2)
            .modelNotes3(UPDATED_MODEL_NOTES_3)
            .modelNotes4(UPDATED_MODEL_NOTES_4)
            .modelInfoHTML(UPDATED_MODEL_INFO_HTML)
            .oemFrontBrakeSystemType(UPDATED_OEM_FRONT_BRAKE_SYSTEM_TYPE)
            .oemFrontBrakeDiscLeft(UPDATED_OEM_FRONT_BRAKE_DISC_LEFT)
            .oemFrontBrakeDiscRight(UPDATED_OEM_FRONT_BRAKE_DISC_RIGHT)
            .oemFrontBrakeDiscBolts(UPDATED_OEM_FRONT_BRAKE_DISC_BOLTS)
            .oemFrontBDQTYPD(UPDATED_OEM_FRONT_BDQTYPD)
            .oemFrontBrakeDiscABSRing(UPDATED_OEM_FRONT_BRAKE_DISC_ABS_RING)
            .oemFrontBrakeCaliper1(UPDATED_OEM_FRONT_BRAKE_CALIPER_1)
            .oemFrontBrakeCaliper2(UPDATED_OEM_FRONT_BRAKE_CALIPER_2)
            .oemFrontBrakeCaliperPin(UPDATED_OEM_FRONT_BRAKE_CALIPER_PIN)
            .oemFrontBrakePadsFrontL(UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_L)
            .oemFrontBrakePadsFrontR(UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_R)
            .oemFrontShoe(UPDATED_OEM_FRONT_SHOE)
            .oemMidldleAxleBrakeDisc(UPDATED_OEM_MIDLDLE_AXLE_BRAKE_DISC)
            .oemMiddleAxleBrakePads(UPDATED_OEM_MIDDLE_AXLE_BRAKE_PADS)
            .oemRearBrakeSystemType(UPDATED_OEM_REAR_BRAKE_SYSTEM_TYPE)
            .oeamRearBrakeDisc(UPDATED_OEAM_REAR_BRAKE_DISC)
            .oeamRearBrakeDiscBolts(UPDATED_OEAM_REAR_BRAKE_DISC_BOLTS)
            .oeamRearBrakeDiscBQTYPD(UPDATED_OEAM_REAR_BRAKE_DISC_BQTYPD)
            .oemRearBrakeCaliper(UPDATED_OEM_REAR_BRAKE_CALIPER)
            .oemRearBrakeCaliperPin(UPDATED_OEM_REAR_BRAKE_CALIPER_PIN)
            .oemRearBrakePads1(UPDATED_OEM_REAR_BRAKE_PADS_1)
            .oemRearBrakePads2(UPDATED_OEM_REAR_BRAKE_PADS_2)
            .oemShoeRear(UPDATED_OEM_SHOE_REAR)
            .oemShoeRear2(UPDATED_OEM_SHOE_REAR_2)
            .oemSlaveCylinder(UPDATED_OEM_SLAVE_CYLINDER)
            .oemChainNo(UPDATED_OEM_CHAIN_NO)
            .oemChainSize(UPDATED_OEM_CHAIN_SIZE)
            .oemChainLinks(UPDATED_OEM_CHAIN_LINKS)
            .oemFrontSprocket(UPDATED_OEM_FRONT_SPROCKET)
            .oemFrontGearing(UPDATED_OEM_FRONT_GEARING)
            .oemFrontGearingMin(UPDATED_OEM_FRONT_GEARING_MIN)
            .oemFrontGearingMax(UPDATED_OEM_FRONT_GEARING_MAX)
            .oemRearSprocket(UPDATED_OEM_REAR_SPROCKET)
            .oemRearGearing(UPDATED_OEM_REAR_GEARING)
            .oemRearGearingMin(UPDATED_OEM_REAR_GEARING_MIN)
            .oemRearGearingMax(UPDATED_OEM_REAR_GEARING_MAX)
            .finalDriveNotes(UPDATED_FINAL_DRIVE_NOTES)
            .chainConvSize(UPDATED_CHAIN_CONV_SIZE)
            .chainConvLinks(UPDATED_CHAIN_CONV_LINKS)
            .oemFrontWheel(UPDATED_OEM_FRONT_WHEEL)
            .oemFrontWheelType(UPDATED_OEM_FRONT_WHEEL_TYPE)
            .oemFrontWheelFront(UPDATED_OEM_FRONT_WHEEL_FRONT)
            .oemFrontWheelTyreSize(UPDATED_OEM_FRONT_WHEEL_TYRE_SIZE)
            .oemFrontHub(UPDATED_OEM_FRONT_HUB)
            .oemFrontWheelbearing1(UPDATED_OEM_FRONT_WHEELBEARING_1)
            .oemFrontWheelbearing2(UPDATED_OEM_FRONT_WHEELBEARING_2)
            .oemFrontWheelSeal(UPDATED_OEM_FRONT_WHEEL_SEAL)
            .oemRearWheel(UPDATED_OEM_REAR_WHEEL)
            .oemRearWheelSize(UPDATED_OEM_REAR_WHEEL_SIZE)
            .oemRearWheelTyre(UPDATED_OEM_REAR_WHEEL_TYRE)
            .oemRearWheelBearing1(UPDATED_OEM_REAR_WHEEL_BEARING_1)
            .oemRearWheelBearing2(UPDATED_OEM_REAR_WHEEL_BEARING_2)
            .oemRearWheelSeal(UPDATED_OEM_REAR_WHEEL_SEAL)
            .frontPadsDiffCaliper(UPDATED_FRONT_PADS_DIFF_CALIPER)
            .qtyBH(UPDATED_QTY_BH)
            .handbrakeParking(UPDATED_HANDBRAKE_PARKING)
            .addNotesToBike(UPDATED_ADD_NOTES_TO_BIKE)
            .dateAndID(UPDATED_DATE_AND_ID)
            .source(UPDATED_SOURCE)
            .tuvRequired(UPDATED_TUV_REQUIRED)
            .tuvTypeCode(UPDATED_TUV_TYPE_CODE)
            .abekba(UPDATED_ABEKBA)
            .tuvFrontDisc(UPDATED_TUV_FRONT_DISC)
            .tuvRearDisc(UPDATED_TUV_REAR_DISC)
            .bremboBrakeDiscFrontRef(UPDATED_BREMBO_BRAKE_DISC_FRONT_REF)
            .ebcBrakeDiscFrontRef(UPDATED_EBC_BRAKE_DISC_FRONT_REF)
            .trwBrakeDiscFrontRef(UPDATED_TRW_BRAKE_DISC_FRONT_REF)
            .mgearBrakeDiscFrontLeftRef(UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF)
            .mgearBrakeDiscFrontRightRef(UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF)
            .mgearBrakeDiscFrontCheck(UPDATED_MGEAR_BRAKE_DISC_FRONT_CHECK)
            .mgearBrakeDiscFrontLeftRef2(UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2)
            .mgearBrakeDiscFrontRightRef2(UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2)
            .mgearBrakeDiscFNeto(UPDATED_MGEAR_BRAKE_DISC_F_NETO)
            .motodiscBrakeDiscFNeto(UPDATED_MOTODISC_BRAKE_DISC_F_NETO)
            .ebcBrakePadsFrontLRef(UPDATED_EBC_BRAKE_PADS_FRONT_L_REF)
            .ebcBrakePadsFrontRRef(UPDATED_EBC_BRAKE_PADS_FRONT_R_REF)
            .mgearBrakePadsFrontLRef(UPDATED_MGEAR_BRAKE_PADS_FRONT_L_REF)
            .mgearBrakePadsFrontRRef(UPDATED_MGEAR_BRAKE_PADS_FRONT_R_REF)
            .mgearBrakePadsFNeto(UPDATED_MGEAR_BRAKE_PADS_F_NETO)
            .motoPadBrakePadsFrontLRef(UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_L_REF)
            .motoPadBrakePadsFrontRRef(UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_R_REF)
            .motopadBrakePadsFNeto(UPDATED_MOTOPAD_BRAKE_PADS_F_NETO)
            .allBallsFCRebuildKit1(UPDATED_ALL_BALLS_FC_REBUILD_KIT_1)
            .allBallsFCPin(UPDATED_ALL_BALLS_FC_PIN)
            .allBallsFMCyRebuildKit(UPDATED_ALL_BALLS_FM_CY_REBUILD_KIT)
            .allBallsFSCRebuildKit(UPDATED_ALL_BALLS_FSC_REBUILD_KIT)
            .newfrenShoeFront(UPDATED_NEWFREN_SHOE_FRONT)
            .mgearMiddleAxleBrakeDiscNeto(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO)
            .mgearMiddleAxleBrakeDiscNeto2(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2)
            .mgearMiddleAxleBrakePadNeto(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO)
            .mgearMiddleAxleBrakePadNeto2(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2)
            .mgearBrakePadsParkRef(UPDATED_MGEAR_BRAKE_PADS_PARK_REF)
            .mgearBrakePadsParkRef2(UPDATED_MGEAR_BRAKE_PADS_PARK_REF_2)
            .ebcBrakeDiscRearRef(UPDATED_EBC_BRAKE_DISC_REAR_REF)
            .bremboBrakeDiscRearRef(UPDATED_BREMBO_BRAKE_DISC_REAR_REF)
            .mgearBrakeDiscRearRef(UPDATED_MGEAR_BRAKE_DISC_REAR_REF)
            .trwBrakeDiscRearRef(UPDATED_TRW_BRAKE_DISC_REAR_REF)
            .mgearBrakeDiscRear(UPDATED_MGEAR_BRAKE_DISC_REAR)
            .allBallsRCRebuildKit1(UPDATED_ALL_BALLS_RC_REBUILD_KIT_1)
            .allBallsRearCaliperBolt(UPDATED_ALL_BALLS_REAR_CALIPER_BOLT)
            .allBallsRMCrRebuildKit(UPDATED_ALL_BALLS_RM_CR_REBUILD_KIT)
            .ebcBrakePadsRearRef(UPDATED_EBC_BRAKE_PADS_REAR_REF)
            .mgearBrakePadsRearNeto(UPDATED_MGEAR_BRAKE_PADS_REAR_NETO)
            .newfrenShoeRear(UPDATED_NEWFREN_SHOE_REAR)
            .allBallsRearBrakePedalKit(UPDATED_ALL_BALLS_REAR_BRAKE_PEDAL_KIT)
            .allBallsCSCRebuildKit(UPDATED_ALL_BALLS_CSC_REBUILD_KIT)
            .frontJTRefFront(UPDATED_FRONT_JT_REF_FRONT)
            .esjotRefFront(UPDATED_ESJOT_REF_FRONT)
            .mgearRefFront(UPDATED_MGEAR_REF_FRONT)
            .mogemaRefFront(UPDATED_MOGEMA_REF_FRONT)
            .supersproxRefFront(UPDATED_SUPERSPROX_REF_FRONT)
            .esjotRefRear(UPDATED_ESJOT_REF_REAR)
            .jtRefRear(UPDATED_JT_REF_REAR)
            .mgearRefRear(UPDATED_MGEAR_REF_REAR)
            .mogemaRefRear(UPDATED_MOGEMA_REF_REAR)
            .supersproxRefRear(UPDATED_SUPERSPROX_REF_REAR)
            .esjotRefFrontConv(UPDATED_ESJOT_REF_FRONT_CONV)
            .jtSprocketRef(UPDATED_JT_SPROCKET_REF)
            .mgearRefFrontConv(UPDATED_MGEAR_REF_FRONT_CONV)
            .mogemarefFrontConv(UPDATED_MOGEMAREF_FRONT_CONV)
            .supersproxRefFrontConv(UPDATED_SUPERSPROX_REF_FRONT_CONV)
            .conversionChain(UPDATED_CONVERSION_CHAIN)
            .mgearSprocketRearConv(UPDATED_MGEAR_SPROCKET_REAR_CONV)
            .esjotRefRearConv(UPDATED_ESJOT_REF_REAR_CONV)
            .mgearRefRearConv(UPDATED_MGEAR_REF_REAR_CONV)
            .mogemaRefRearConv(UPDATED_MOGEMA_REF_REAR_CONV)
            .supersproxRefRearConv(UPDATED_SUPERSPROX_REF_REAR_CONV)
            .allBallsFWBearingKit1(UPDATED_ALL_BALLS_FW_BEARING_KIT_1)
            .allBallsFWBearingKit2(UPDATED_ALL_BALLS_FW_BEARING_KIT_2)
            .allBallsRWBearingKit1(UPDATED_ALL_BALLS_RW_BEARING_KIT_1)
            .allBallsRWBearingKit2(UPDATED_ALL_BALLS_RW_BEARING_KIT_2)
            .allBallsRWBearingUpgrade(UPDATED_ALL_BALLS_RW_BEARING_UPGRADE)
            .oemSparkPlug(UPDATED_OEM_SPARK_PLUG)
            .oemSparkPlugQTY(UPDATED_OEM_SPARK_PLUG_QTY)
            .ngkSparkPlugSKUs(UPDATED_NGK_SPARK_PLUG_SK_US)
            .oemAlternator(UPDATED_OEM_ALTERNATOR)
            .oemVoltageRegulator(UPDATED_OEM_VOLTAGE_REGULATOR)
            .arrowheadAlternator(UPDATED_ARROWHEAD_ALTERNATOR)
            .arrowheadAlternator2(UPDATED_ARROWHEAD_ALTERNATOR_2)
            .arrowheadCDIModule(UPDATED_ARROWHEAD_CDI_MODULE)
            .arrowheadChargingCoil(UPDATED_ARROWHEAD_CHARGING_COIL)
            .arrowheadIgnitionCoil(UPDATED_ARROWHEAD_IGNITION_COIL)
            .arrowheadStatorCoil(UPDATED_ARROWHEAD_STATOR_COIL)
            .arrowheadVoltageRegulator(UPDATED_ARROWHEAD_VOLTAGE_REGULATOR)
            .arrowheadPowerShiftCM(UPDATED_ARROWHEAD_POWER_SHIFT_CM)
            .arrowheadStarterDrive(UPDATED_ARROWHEAD_STARTER_DRIVE)
            .arrowheadStarterMotor(UPDATED_ARROWHEAD_STARTER_MOTOR)
            .arrowheadStarterRelay(UPDATED_ARROWHEAD_STARTER_RELAY)
            .oemBattery(UPDATED_OEM_BATTERY)
            .ssbAGMBattery(UPDATED_SSB_AGM_BATTERY)
            .oemAirFilter(UPDATED_OEM_AIR_FILTER)
            .knAirFilter(UPDATED_KN_AIR_FILTER)
            .motorexAirFilter(UPDATED_MOTOREX_AIR_FILTER)
            .motorexAirFilterPreoiled(UPDATED_MOTOREX_AIR_FILTER_PREOILED)
            .oemOilFilter1(UPDATED_OEM_OIL_FILTER_1)
            .knOilFilter1(UPDATED_KN_OIL_FILTER_1)
            .oemOilFilter2(UPDATED_OEM_OIL_FILTER_2)
            .knOilFilter2(UPDATED_KN_OIL_FILTER_2)
            .motionProOilFilterMagnet(UPDATED_MOTION_PRO_OIL_FILTER_MAGNET)
            .oemSteeringBearing(UPDATED_OEM_STEERING_BEARING)
            .oemSteeringSeal(UPDATED_OEM_STEERING_SEAL)
            .allBallsSBSealKit1(UPDATED_ALL_BALLS_SB_SEAL_KIT_1)
            .allBallsSBSealKit2(UPDATED_ALL_BALLS_SB_SEAL_KIT_2)
            .allBallsSBSealKitLower(UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER)
            .allBallsSBSealKitLower2(UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER_2)
            .allBallsCBSealKit(UPDATED_ALL_BALLS_CB_SEAL_KIT)
            .oemForkAssemblyLeft(UPDATED_OEM_FORK_ASSEMBLY_LEFT)
            .oemForkAssemblyRight(UPDATED_OEM_FORK_ASSEMBLY_RIGHT)
            .oemForkSeals(UPDATED_OEM_FORK_SEALS)
            .allBallsForkSeals(UPDATED_ALL_BALLS_FORK_SEALS)
            .xprForkSeals(UPDATED_XPR_FORK_SEALS)
            .allBallsForkBushingKit(UPDATED_ALL_BALLS_FORK_BUSHING_KIT)
            .motionProMicroForkBleeder(UPDATED_MOTION_PRO_MICRO_FORK_BLEEDER)
            .motionProCRProThottleKit(UPDATED_MOTION_PRO_CR_PRO_THOTTLE_KIT)
            .oemCableSpeedo(UPDATED_OEM_CABLE_SPEEDO)
            .motionProCableSpeedo(UPDATED_MOTION_PRO_CABLE_SPEEDO)
            .motionProCableThrottleTube(UPDATED_MOTION_PRO_CABLE_THROTTLE_TUBE)
            .crossproRadiatorGuard(UPDATED_CROSSPRO_RADIATOR_GUARD)
            .oemClutchFibres(UPDATED_OEM_CLUTCH_FIBRES)
            .oemClutchFibresSteels(UPDATED_OEM_CLUTCH_FIBRES_STEELS)
            .newfrenClutchKit(UPDATED_NEWFREN_CLUTCH_KIT)
            .newfrenClutchSpringKits(UPDATED_NEWFREN_CLUTCH_SPRING_KITS)
            .allBallsCMCRebuiltKit(UPDATED_ALL_BALLS_CMC_REBUILT_KIT)
            .wisecoForgedClutchBasket(UPDATED_WISECO_FORGED_CLUTCH_BASKET)
            .wisecoBottemEndRebuildKit(UPDATED_WISECO_BOTTEM_END_REBUILD_KIT)
            .wrenchRERebuildKit(UPDATED_WRENCH_RE_REBUILD_KIT)
            .oemCarbAssembly(UPDATED_OEM_CARB_ASSEMBLY)
            .allBallsCarbRepairKit(UPDATED_ALL_BALLS_CARB_REPAIR_KIT)
            .allBallsCRMidBodyGasket1(UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_1)
            .allBallsCRMidBodyGasket2(UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_2)
            .allBallsFuelTapRepairKit(UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT)
            .allBallsFuelTapRepairKit2(UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2)
            .fuelStarFuelValveKit(UPDATED_FUEL_STAR_FUEL_VALVE_KIT)
            .fuelStarFuelValveKit2(UPDATED_FUEL_STAR_FUEL_VALVE_KIT_2)
            .fuelStarHoseClampKit(UPDATED_FUEL_STAR_HOSE_CLAMP_KIT)
            .rgEngineCoverLHS(UPDATED_RG_ENGINE_COVER_LHS)
            .rgTailTidy(UPDATED_RG_TAIL_TIDY)
            .allBallsLBSealKit(UPDATED_ALL_BALLS_LB_SEAL_KIT)
            .allBallsLRSBearingKit(UPDATED_ALL_BALLS_LRS_BEARING_KIT)
            .allBallsURSBearingKit(UPDATED_ALL_BALLS_URS_BEARING_KIT)
            .allBallsULSBearingKit(UPDATED_ALL_BALLS_ULS_BEARING_KIT)
            .allBallsSBSealKit(UPDATED_ALL_BALLS_SB_SEAL_KIT)
            .pivotWorksSTBearingKit(UPDATED_PIVOT_WORKS_ST_BEARING_KIT)
            .pivotWorksSRebuildKit(UPDATED_PIVOT_WORKS_S_REBUILD_KIT)
            .mpForkSealDriver(UPDATED_MP_FORK_SEAL_DRIVER)
            .mpValveSealInstallTool(UPDATED_MP_VALVE_SEAL_INSTALL_TOOL)
            .winderosaGasketKitTopEnd(UPDATED_WINDEROSA_GASKET_KIT_TOP_END)
            .winderosaGasketKitOilSeals(UPDATED_WINDEROSA_GASKET_KIT_OIL_SEALS)
            .oemExhaustGasket(UPDATED_OEM_EXHAUST_GASKET)
            .winderosaGasketExhaust(UPDATED_WINDEROSA_GASKET_EXHAUST)
            .winderosaWaterPumpRebuildKit(UPDATED_WINDEROSA_WATER_PUMP_REBUILD_KIT)
            .hotRodsConnectingRodKit(UPDATED_HOT_RODS_CONNECTING_ROD_KIT)
            .hotRodsCounterBalRebuildKit(UPDATED_HOT_RODS_COUNTER_BAL_REBUILD_KIT)
            .hotRodsBERebuildKit(UPDATED_HOT_RODS_BE_REBUILD_KIT)
            .hotRodsBERebuildKitSt(UPDATED_HOT_RODS_BE_REBUILD_KIT_ST)
            .hotRodsCylinderHead(UPDATED_HOT_RODS_CYLINDER_HEAD)
            .hotRodsMainBearingSealKit(UPDATED_HOT_RODS_MAIN_BEARING_SEAL_KIT)
            .hotRodsTransmissionBearings(UPDATED_HOT_RODS_TRANSMISSION_BEARINGS)
            .hotRodsWristPinBearings(UPDATED_HOT_RODS_WRIST_PIN_BEARINGS)
            .hotRodsSOHCCamshaftStage1(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_1)
            .hotRodsSOHCCamshaftStage2(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_2)
            .hotRodsSOHCCamshaftStage3(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_3)
            .hotRodsDOHCCamshaftStage1Intake(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE)
            .hotRodsDOHCCamshaftStage1Exhaust(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST)
            .hotRodsDOHCCamshaftStage2Intake(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE)
            .hotRodsDOHCCamshaftStage2Exhaust(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST);
        BikeDTO bikeDTO = bikeMapper.toDto(updatedBike);

        restBikeMockMvc.perform(put("/api/bikes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeDTO)))
            .andExpect(status().isOk());

        // Validate the Bike in the database
        List<Bike> bikeList = bikeRepository.findAll();
        assertThat(bikeList).hasSize(databaseSizeBeforeUpdate);
        Bike testBike = bikeList.get(bikeList.size() - 1);
        assertThat(testBike.getVisibilityAU()).isEqualTo(UPDATED_VISIBILITY_AU);
        assertThat(testBike.getVisibilityEU()).isEqualTo(UPDATED_VISIBILITY_EU);
        assertThat(testBike.getInactive()).isEqualTo(UPDATED_INACTIVE);
        assertThat(testBike.getOemconfirmed()).isEqualTo(UPDATED_OEMCONFIRMED);
        assertThat(testBike.getOesource()).isEqualTo(UPDATED_OESOURCE);
        assertThat(testBike.getEpid()).isEqualTo(UPDATED_EPID);
        assertThat(testBike.getModeltype1()).isEqualTo(UPDATED_MODELTYPE_1);
        assertThat(testBike.getModeltype2()).isEqualTo(UPDATED_MODELTYPE_2);
        assertThat(testBike.getManufacturer()).isEqualTo(UPDATED_MANUFACTURER);
        assertThat(testBike.getStrokes()).isEqualTo(UPDATED_STROKES);
        assertThat(testBike.getCapacity()).isEqualTo(UPDATED_CAPACITY);
        assertThat(testBike.getModelName()).isEqualTo(UPDATED_MODEL_NAME);
        assertThat(testBike.getModelYearCode()).isEqualTo(UPDATED_MODEL_YEAR_CODE);
        assertThat(testBike.getModelTypeCode()).isEqualTo(UPDATED_MODEL_TYPE_CODE);
        assertThat(testBike.getYear()).isEqualTo(UPDATED_YEAR);
        assertThat(testBike.getFinalDriveType()).isEqualTo(UPDATED_FINAL_DRIVE_TYPE);
        assertThat(testBike.getCategoryPath()).isEqualTo(UPDATED_CATEGORY_PATH);
        assertThat(testBike.getModelNotes()).isEqualTo(UPDATED_MODEL_NOTES);
        assertThat(testBike.getModelNotes2()).isEqualTo(UPDATED_MODEL_NOTES_2);
        assertThat(testBike.getModelNotes3()).isEqualTo(UPDATED_MODEL_NOTES_3);
        assertThat(testBike.getModelNotes4()).isEqualTo(UPDATED_MODEL_NOTES_4);
        assertThat(testBike.getModelInfoHTML()).isEqualTo(UPDATED_MODEL_INFO_HTML);
        assertThat(testBike.getOemFrontBrakeSystemType()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_SYSTEM_TYPE);
        assertThat(testBike.getOemFrontBrakeDiscLeft()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_DISC_LEFT);
        assertThat(testBike.getOemFrontBrakeDiscRight()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_DISC_RIGHT);
        assertThat(testBike.getOemFrontBrakeDiscBolts()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_DISC_BOLTS);
        assertThat(testBike.getOemFrontBDQTYPD()).isEqualTo(UPDATED_OEM_FRONT_BDQTYPD);
        assertThat(testBike.getOemFrontBrakeDiscABSRing()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_DISC_ABS_RING);
        assertThat(testBike.getOemFrontBrakeCaliper1()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_CALIPER_1);
        assertThat(testBike.getOemFrontBrakeCaliper2()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_CALIPER_2);
        assertThat(testBike.getOemFrontBrakeCaliperPin()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_CALIPER_PIN);
        assertThat(testBike.getOemFrontBrakePadsFrontL()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_L);
        assertThat(testBike.getOemFrontBrakePadsFrontR()).isEqualTo(UPDATED_OEM_FRONT_BRAKE_PADS_FRONT_R);
        assertThat(testBike.getOemFrontShoe()).isEqualTo(UPDATED_OEM_FRONT_SHOE);
        assertThat(testBike.getOemMidldleAxleBrakeDisc()).isEqualTo(UPDATED_OEM_MIDLDLE_AXLE_BRAKE_DISC);
        assertThat(testBike.getOemMiddleAxleBrakePads()).isEqualTo(UPDATED_OEM_MIDDLE_AXLE_BRAKE_PADS);
        assertThat(testBike.getOemRearBrakeSystemType()).isEqualTo(UPDATED_OEM_REAR_BRAKE_SYSTEM_TYPE);
        assertThat(testBike.getOeamRearBrakeDisc()).isEqualTo(UPDATED_OEAM_REAR_BRAKE_DISC);
        assertThat(testBike.getOeamRearBrakeDiscBolts()).isEqualTo(UPDATED_OEAM_REAR_BRAKE_DISC_BOLTS);
        assertThat(testBike.getOeamRearBrakeDiscBQTYPD()).isEqualTo(UPDATED_OEAM_REAR_BRAKE_DISC_BQTYPD);
        assertThat(testBike.getOemRearBrakeCaliper()).isEqualTo(UPDATED_OEM_REAR_BRAKE_CALIPER);
        assertThat(testBike.getOemRearBrakeCaliperPin()).isEqualTo(UPDATED_OEM_REAR_BRAKE_CALIPER_PIN);
        assertThat(testBike.getOemRearBrakePads1()).isEqualTo(UPDATED_OEM_REAR_BRAKE_PADS_1);
        assertThat(testBike.getOemRearBrakePads2()).isEqualTo(UPDATED_OEM_REAR_BRAKE_PADS_2);
        assertThat(testBike.getOemShoeRear()).isEqualTo(UPDATED_OEM_SHOE_REAR);
        assertThat(testBike.getOemShoeRear2()).isEqualTo(UPDATED_OEM_SHOE_REAR_2);
        assertThat(testBike.getOemSlaveCylinder()).isEqualTo(UPDATED_OEM_SLAVE_CYLINDER);
        assertThat(testBike.getOemChainNo()).isEqualTo(UPDATED_OEM_CHAIN_NO);
        assertThat(testBike.getOemChainSize()).isEqualTo(UPDATED_OEM_CHAIN_SIZE);
        assertThat(testBike.getOemChainLinks()).isEqualTo(UPDATED_OEM_CHAIN_LINKS);
        assertThat(testBike.getOemFrontSprocket()).isEqualTo(UPDATED_OEM_FRONT_SPROCKET);
        assertThat(testBike.getOemFrontGearing()).isEqualTo(UPDATED_OEM_FRONT_GEARING);
        assertThat(testBike.getOemFrontGearingMin()).isEqualTo(UPDATED_OEM_FRONT_GEARING_MIN);
        assertThat(testBike.getOemFrontGearingMax()).isEqualTo(UPDATED_OEM_FRONT_GEARING_MAX);
        assertThat(testBike.getOemRearSprocket()).isEqualTo(UPDATED_OEM_REAR_SPROCKET);
        assertThat(testBike.getOemRearGearing()).isEqualTo(UPDATED_OEM_REAR_GEARING);
        assertThat(testBike.getOemRearGearingMin()).isEqualTo(UPDATED_OEM_REAR_GEARING_MIN);
        assertThat(testBike.getOemRearGearingMax()).isEqualTo(UPDATED_OEM_REAR_GEARING_MAX);
        assertThat(testBike.getFinalDriveNotes()).isEqualTo(UPDATED_FINAL_DRIVE_NOTES);
        assertThat(testBike.getChainConvSize()).isEqualTo(UPDATED_CHAIN_CONV_SIZE);
        assertThat(testBike.getChainConvLinks()).isEqualTo(UPDATED_CHAIN_CONV_LINKS);
        assertThat(testBike.getOemFrontWheel()).isEqualTo(UPDATED_OEM_FRONT_WHEEL);
        assertThat(testBike.getOemFrontWheelType()).isEqualTo(UPDATED_OEM_FRONT_WHEEL_TYPE);
        assertThat(testBike.getOemFrontWheelFront()).isEqualTo(UPDATED_OEM_FRONT_WHEEL_FRONT);
        assertThat(testBike.getOemFrontWheelTyreSize()).isEqualTo(UPDATED_OEM_FRONT_WHEEL_TYRE_SIZE);
        assertThat(testBike.getOemFrontHub()).isEqualTo(UPDATED_OEM_FRONT_HUB);
        assertThat(testBike.getOemFrontWheelbearing1()).isEqualTo(UPDATED_OEM_FRONT_WHEELBEARING_1);
        assertThat(testBike.getOemFrontWheelbearing2()).isEqualTo(UPDATED_OEM_FRONT_WHEELBEARING_2);
        assertThat(testBike.getOemFrontWheelSeal()).isEqualTo(UPDATED_OEM_FRONT_WHEEL_SEAL);
        assertThat(testBike.getOemRearWheel()).isEqualTo(UPDATED_OEM_REAR_WHEEL);
        assertThat(testBike.getOemRearWheelSize()).isEqualTo(UPDATED_OEM_REAR_WHEEL_SIZE);
        assertThat(testBike.getOemRearWheelTyre()).isEqualTo(UPDATED_OEM_REAR_WHEEL_TYRE);
        assertThat(testBike.getOemRearWheelBearing1()).isEqualTo(UPDATED_OEM_REAR_WHEEL_BEARING_1);
        assertThat(testBike.getOemRearWheelBearing2()).isEqualTo(UPDATED_OEM_REAR_WHEEL_BEARING_2);
        assertThat(testBike.getOemRearWheelSeal()).isEqualTo(UPDATED_OEM_REAR_WHEEL_SEAL);
        assertThat(testBike.getFrontPadsDiffCaliper()).isEqualTo(UPDATED_FRONT_PADS_DIFF_CALIPER);
        assertThat(testBike.getQtyBH()).isEqualTo(UPDATED_QTY_BH);
        assertThat(testBike.getHandbrakeParking()).isEqualTo(UPDATED_HANDBRAKE_PARKING);
        assertThat(testBike.getAddNotesToBike()).isEqualTo(UPDATED_ADD_NOTES_TO_BIKE);
        assertThat(testBike.getDateAndID()).isEqualTo(UPDATED_DATE_AND_ID);
        assertThat(testBike.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testBike.getTuvRequired()).isEqualTo(UPDATED_TUV_REQUIRED);
        assertThat(testBike.getTuvTypeCode()).isEqualTo(UPDATED_TUV_TYPE_CODE);
        assertThat(testBike.getAbekba()).isEqualTo(UPDATED_ABEKBA);
        assertThat(testBike.getTuvFrontDisc()).isEqualTo(UPDATED_TUV_FRONT_DISC);
        assertThat(testBike.getTuvRearDisc()).isEqualTo(UPDATED_TUV_REAR_DISC);
        assertThat(testBike.getBremboBrakeDiscFrontRef()).isEqualTo(UPDATED_BREMBO_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getEbcBrakeDiscFrontRef()).isEqualTo(UPDATED_EBC_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getTrwBrakeDiscFrontRef()).isEqualTo(UPDATED_TRW_BRAKE_DISC_FRONT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontLeftRef()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontRightRef()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF);
        assertThat(testBike.getMgearBrakeDiscFrontCheck()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_FRONT_CHECK);
        assertThat(testBike.getMgearBrakeDiscFrontLeftRef2()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_FRONT_LEFT_REF_2);
        assertThat(testBike.getMgearBrakeDiscFrontRightRef2()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_FRONT_RIGHT_REF_2);
        assertThat(testBike.getMgearBrakeDiscFNeto()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_F_NETO);
        assertThat(testBike.getMotodiscBrakeDiscFNeto()).isEqualTo(UPDATED_MOTODISC_BRAKE_DISC_F_NETO);
        assertThat(testBike.getEbcBrakePadsFrontLRef()).isEqualTo(UPDATED_EBC_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getEbcBrakePadsFrontRRef()).isEqualTo(UPDATED_EBC_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMgearBrakePadsFrontLRef()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getMgearBrakePadsFrontRRef()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMgearBrakePadsFNeto()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_F_NETO);
        assertThat(testBike.getMotoPadBrakePadsFrontLRef()).isEqualTo(UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_L_REF);
        assertThat(testBike.getMotoPadBrakePadsFrontRRef()).isEqualTo(UPDATED_MOTO_PAD_BRAKE_PADS_FRONT_R_REF);
        assertThat(testBike.getMotopadBrakePadsFNeto()).isEqualTo(UPDATED_MOTOPAD_BRAKE_PADS_F_NETO);
        assertThat(testBike.getAllBallsFCRebuildKit1()).isEqualTo(UPDATED_ALL_BALLS_FC_REBUILD_KIT_1);
        assertThat(testBike.getAllBallsFCPin()).isEqualTo(UPDATED_ALL_BALLS_FC_PIN);
        assertThat(testBike.getAllBallsFMCyRebuildKit()).isEqualTo(UPDATED_ALL_BALLS_FM_CY_REBUILD_KIT);
        assertThat(testBike.getAllBallsFSCRebuildKit()).isEqualTo(UPDATED_ALL_BALLS_FSC_REBUILD_KIT);
        assertThat(testBike.getNewfrenShoeFront()).isEqualTo(UPDATED_NEWFREN_SHOE_FRONT);
        assertThat(testBike.getMgearMiddleAxleBrakeDiscNeto()).isEqualTo(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO);
        assertThat(testBike.getMgearMiddleAxleBrakeDiscNeto2()).isEqualTo(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_DISC_NETO_2);
        assertThat(testBike.getMgearMiddleAxleBrakePadNeto()).isEqualTo(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO);
        assertThat(testBike.getMgearMiddleAxleBrakePadNeto2()).isEqualTo(UPDATED_MGEAR_MIDDLE_AXLE_BRAKE_PAD_NETO_2);
        assertThat(testBike.getMgearBrakePadsParkRef()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_PARK_REF);
        assertThat(testBike.getMgearBrakePadsParkRef2()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_PARK_REF_2);
        assertThat(testBike.getEbcBrakeDiscRearRef()).isEqualTo(UPDATED_EBC_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getBremboBrakeDiscRearRef()).isEqualTo(UPDATED_BREMBO_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getMgearBrakeDiscRearRef()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getTrwBrakeDiscRearRef()).isEqualTo(UPDATED_TRW_BRAKE_DISC_REAR_REF);
        assertThat(testBike.getMgearBrakeDiscRear()).isEqualTo(UPDATED_MGEAR_BRAKE_DISC_REAR);
        assertThat(testBike.getAllBallsRCRebuildKit1()).isEqualTo(UPDATED_ALL_BALLS_RC_REBUILD_KIT_1);
        assertThat(testBike.getAllBallsRearCaliperBolt()).isEqualTo(UPDATED_ALL_BALLS_REAR_CALIPER_BOLT);
        assertThat(testBike.getAllBallsRMCrRebuildKit()).isEqualTo(UPDATED_ALL_BALLS_RM_CR_REBUILD_KIT);
        assertThat(testBike.getEbcBrakePadsRearRef()).isEqualTo(UPDATED_EBC_BRAKE_PADS_REAR_REF);
        assertThat(testBike.getMgearBrakePadsRearNeto()).isEqualTo(UPDATED_MGEAR_BRAKE_PADS_REAR_NETO);
        assertThat(testBike.getNewfrenShoeRear()).isEqualTo(UPDATED_NEWFREN_SHOE_REAR);
        assertThat(testBike.getAllBallsRearBrakePedalKit()).isEqualTo(UPDATED_ALL_BALLS_REAR_BRAKE_PEDAL_KIT);
        assertThat(testBike.getAllBallsCSCRebuildKit()).isEqualTo(UPDATED_ALL_BALLS_CSC_REBUILD_KIT);
        assertThat(testBike.getFrontJTRefFront()).isEqualTo(UPDATED_FRONT_JT_REF_FRONT);
        assertThat(testBike.getEsjotRefFront()).isEqualTo(UPDATED_ESJOT_REF_FRONT);
        assertThat(testBike.getMgearRefFront()).isEqualTo(UPDATED_MGEAR_REF_FRONT);
        assertThat(testBike.getMogemaRefFront()).isEqualTo(UPDATED_MOGEMA_REF_FRONT);
        assertThat(testBike.getSupersproxRefFront()).isEqualTo(UPDATED_SUPERSPROX_REF_FRONT);
        assertThat(testBike.getEsjotRefRear()).isEqualTo(UPDATED_ESJOT_REF_REAR);
        assertThat(testBike.getJtRefRear()).isEqualTo(UPDATED_JT_REF_REAR);
        assertThat(testBike.getMgearRefRear()).isEqualTo(UPDATED_MGEAR_REF_REAR);
        assertThat(testBike.getMogemaRefRear()).isEqualTo(UPDATED_MOGEMA_REF_REAR);
        assertThat(testBike.getSupersproxRefRear()).isEqualTo(UPDATED_SUPERSPROX_REF_REAR);
        assertThat(testBike.getEsjotRefFrontConv()).isEqualTo(UPDATED_ESJOT_REF_FRONT_CONV);
        assertThat(testBike.getJtSprocketRef()).isEqualTo(UPDATED_JT_SPROCKET_REF);
        assertThat(testBike.getMgearRefFrontConv()).isEqualTo(UPDATED_MGEAR_REF_FRONT_CONV);
        assertThat(testBike.getMogemarefFrontConv()).isEqualTo(UPDATED_MOGEMAREF_FRONT_CONV);
        assertThat(testBike.getSupersproxRefFrontConv()).isEqualTo(UPDATED_SUPERSPROX_REF_FRONT_CONV);
        assertThat(testBike.getConversionChain()).isEqualTo(UPDATED_CONVERSION_CHAIN);
        assertThat(testBike.getMgearSprocketRearConv()).isEqualTo(UPDATED_MGEAR_SPROCKET_REAR_CONV);
        assertThat(testBike.getEsjotRefRearConv()).isEqualTo(UPDATED_ESJOT_REF_REAR_CONV);
        assertThat(testBike.getMgearRefRearConv()).isEqualTo(UPDATED_MGEAR_REF_REAR_CONV);
        assertThat(testBike.getMogemaRefRearConv()).isEqualTo(UPDATED_MOGEMA_REF_REAR_CONV);
        assertThat(testBike.getSupersproxRefRearConv()).isEqualTo(UPDATED_SUPERSPROX_REF_REAR_CONV);
        assertThat(testBike.getAllBallsFWBearingKit1()).isEqualTo(UPDATED_ALL_BALLS_FW_BEARING_KIT_1);
        assertThat(testBike.getAllBallsFWBearingKit2()).isEqualTo(UPDATED_ALL_BALLS_FW_BEARING_KIT_2);
        assertThat(testBike.getAllBallsRWBearingKit1()).isEqualTo(UPDATED_ALL_BALLS_RW_BEARING_KIT_1);
        assertThat(testBike.getAllBallsRWBearingKit2()).isEqualTo(UPDATED_ALL_BALLS_RW_BEARING_KIT_2);
        assertThat(testBike.getAllBallsRWBearingUpgrade()).isEqualTo(UPDATED_ALL_BALLS_RW_BEARING_UPGRADE);
        assertThat(testBike.getOemSparkPlug()).isEqualTo(UPDATED_OEM_SPARK_PLUG);
        assertThat(testBike.getOemSparkPlugQTY()).isEqualTo(UPDATED_OEM_SPARK_PLUG_QTY);
        assertThat(testBike.getNgkSparkPlugSKUs()).isEqualTo(UPDATED_NGK_SPARK_PLUG_SK_US);
        assertThat(testBike.getOemAlternator()).isEqualTo(UPDATED_OEM_ALTERNATOR);
        assertThat(testBike.getOemVoltageRegulator()).isEqualTo(UPDATED_OEM_VOLTAGE_REGULATOR);
        assertThat(testBike.getArrowheadAlternator()).isEqualTo(UPDATED_ARROWHEAD_ALTERNATOR);
        assertThat(testBike.getArrowheadAlternator2()).isEqualTo(UPDATED_ARROWHEAD_ALTERNATOR_2);
        assertThat(testBike.getArrowheadCDIModule()).isEqualTo(UPDATED_ARROWHEAD_CDI_MODULE);
        assertThat(testBike.getArrowheadChargingCoil()).isEqualTo(UPDATED_ARROWHEAD_CHARGING_COIL);
        assertThat(testBike.getArrowheadIgnitionCoil()).isEqualTo(UPDATED_ARROWHEAD_IGNITION_COIL);
        assertThat(testBike.getArrowheadStatorCoil()).isEqualTo(UPDATED_ARROWHEAD_STATOR_COIL);
        assertThat(testBike.getArrowheadVoltageRegulator()).isEqualTo(UPDATED_ARROWHEAD_VOLTAGE_REGULATOR);
        assertThat(testBike.getArrowheadPowerShiftCM()).isEqualTo(UPDATED_ARROWHEAD_POWER_SHIFT_CM);
        assertThat(testBike.getArrowheadStarterDrive()).isEqualTo(UPDATED_ARROWHEAD_STARTER_DRIVE);
        assertThat(testBike.getArrowheadStarterMotor()).isEqualTo(UPDATED_ARROWHEAD_STARTER_MOTOR);
        assertThat(testBike.getArrowheadStarterRelay()).isEqualTo(UPDATED_ARROWHEAD_STARTER_RELAY);
        assertThat(testBike.getOemBattery()).isEqualTo(UPDATED_OEM_BATTERY);
        assertThat(testBike.getSsbAGMBattery()).isEqualTo(UPDATED_SSB_AGM_BATTERY);
        assertThat(testBike.getOemAirFilter()).isEqualTo(UPDATED_OEM_AIR_FILTER);
        assertThat(testBike.getKnAirFilter()).isEqualTo(UPDATED_KN_AIR_FILTER);
        assertThat(testBike.getMotorexAirFilter()).isEqualTo(UPDATED_MOTOREX_AIR_FILTER);
        assertThat(testBike.getMotorexAirFilterPreoiled()).isEqualTo(UPDATED_MOTOREX_AIR_FILTER_PREOILED);
        assertThat(testBike.getOemOilFilter1()).isEqualTo(UPDATED_OEM_OIL_FILTER_1);
        assertThat(testBike.getKnOilFilter1()).isEqualTo(UPDATED_KN_OIL_FILTER_1);
        assertThat(testBike.getOemOilFilter2()).isEqualTo(UPDATED_OEM_OIL_FILTER_2);
        assertThat(testBike.getKnOilFilter2()).isEqualTo(UPDATED_KN_OIL_FILTER_2);
        assertThat(testBike.getMotionProOilFilterMagnet()).isEqualTo(UPDATED_MOTION_PRO_OIL_FILTER_MAGNET);
        assertThat(testBike.getOemSteeringBearing()).isEqualTo(UPDATED_OEM_STEERING_BEARING);
        assertThat(testBike.getOemSteeringSeal()).isEqualTo(UPDATED_OEM_STEERING_SEAL);
        assertThat(testBike.getAllBallsSBSealKit1()).isEqualTo(UPDATED_ALL_BALLS_SB_SEAL_KIT_1);
        assertThat(testBike.getAllBallsSBSealKit2()).isEqualTo(UPDATED_ALL_BALLS_SB_SEAL_KIT_2);
        assertThat(testBike.getAllBallsSBSealKitLower()).isEqualTo(UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER);
        assertThat(testBike.getAllBallsSBSealKitLower2()).isEqualTo(UPDATED_ALL_BALLS_SB_SEAL_KIT_LOWER_2);
        assertThat(testBike.getAllBallsCBSealKit()).isEqualTo(UPDATED_ALL_BALLS_CB_SEAL_KIT);
        assertThat(testBike.getOemForkAssemblyLeft()).isEqualTo(UPDATED_OEM_FORK_ASSEMBLY_LEFT);
        assertThat(testBike.getOemForkAssemblyRight()).isEqualTo(UPDATED_OEM_FORK_ASSEMBLY_RIGHT);
        assertThat(testBike.getOemForkSeals()).isEqualTo(UPDATED_OEM_FORK_SEALS);
        assertThat(testBike.getAllBallsForkSeals()).isEqualTo(UPDATED_ALL_BALLS_FORK_SEALS);
        assertThat(testBike.getXprForkSeals()).isEqualTo(UPDATED_XPR_FORK_SEALS);
        assertThat(testBike.getAllBallsForkBushingKit()).isEqualTo(UPDATED_ALL_BALLS_FORK_BUSHING_KIT);
        assertThat(testBike.getMotionProMicroForkBleeder()).isEqualTo(UPDATED_MOTION_PRO_MICRO_FORK_BLEEDER);
        assertThat(testBike.getMotionProCRProThottleKit()).isEqualTo(UPDATED_MOTION_PRO_CR_PRO_THOTTLE_KIT);
        assertThat(testBike.getOemCableSpeedo()).isEqualTo(UPDATED_OEM_CABLE_SPEEDO);
        assertThat(testBike.getMotionProCableSpeedo()).isEqualTo(UPDATED_MOTION_PRO_CABLE_SPEEDO);
        assertThat(testBike.getMotionProCableThrottleTube()).isEqualTo(UPDATED_MOTION_PRO_CABLE_THROTTLE_TUBE);
        assertThat(testBike.getCrossproRadiatorGuard()).isEqualTo(UPDATED_CROSSPRO_RADIATOR_GUARD);
        assertThat(testBike.getOemClutchFibres()).isEqualTo(UPDATED_OEM_CLUTCH_FIBRES);
        assertThat(testBike.getOemClutchFibresSteels()).isEqualTo(UPDATED_OEM_CLUTCH_FIBRES_STEELS);
        assertThat(testBike.getNewfrenClutchKit()).isEqualTo(UPDATED_NEWFREN_CLUTCH_KIT);
        assertThat(testBike.getNewfrenClutchSpringKits()).isEqualTo(UPDATED_NEWFREN_CLUTCH_SPRING_KITS);
        assertThat(testBike.getAllBallsCMCRebuiltKit()).isEqualTo(UPDATED_ALL_BALLS_CMC_REBUILT_KIT);
        assertThat(testBike.getWisecoForgedClutchBasket()).isEqualTo(UPDATED_WISECO_FORGED_CLUTCH_BASKET);
        assertThat(testBike.getWisecoBottemEndRebuildKit()).isEqualTo(UPDATED_WISECO_BOTTEM_END_REBUILD_KIT);
        assertThat(testBike.getWrenchRERebuildKit()).isEqualTo(UPDATED_WRENCH_RE_REBUILD_KIT);
        assertThat(testBike.getOemCarbAssembly()).isEqualTo(UPDATED_OEM_CARB_ASSEMBLY);
        assertThat(testBike.getAllBallsCarbRepairKit()).isEqualTo(UPDATED_ALL_BALLS_CARB_REPAIR_KIT);
        assertThat(testBike.getAllBallsCRMidBodyGasket1()).isEqualTo(UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_1);
        assertThat(testBike.getAllBallsCRMidBodyGasket2()).isEqualTo(UPDATED_ALL_BALLS_CR_MID_BODY_GASKET_2);
        assertThat(testBike.getAllBallsFuelTapRepairKit()).isEqualTo(UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT);
        assertThat(testBike.getAllBallsFuelTapRepairKit2()).isEqualTo(UPDATED_ALL_BALLS_FUEL_TAP_REPAIR_KIT_2);
        assertThat(testBike.getFuelStarFuelValveKit()).isEqualTo(UPDATED_FUEL_STAR_FUEL_VALVE_KIT);
        assertThat(testBike.getFuelStarFuelValveKit2()).isEqualTo(UPDATED_FUEL_STAR_FUEL_VALVE_KIT_2);
        assertThat(testBike.getFuelStarHoseClampKit()).isEqualTo(UPDATED_FUEL_STAR_HOSE_CLAMP_KIT);
        assertThat(testBike.getRgEngineCoverLHS()).isEqualTo(UPDATED_RG_ENGINE_COVER_LHS);
        assertThat(testBike.getRgTailTidy()).isEqualTo(UPDATED_RG_TAIL_TIDY);
        assertThat(testBike.getAllBallsLBSealKit()).isEqualTo(UPDATED_ALL_BALLS_LB_SEAL_KIT);
        assertThat(testBike.getAllBallsLRSBearingKit()).isEqualTo(UPDATED_ALL_BALLS_LRS_BEARING_KIT);
        assertThat(testBike.getAllBallsURSBearingKit()).isEqualTo(UPDATED_ALL_BALLS_URS_BEARING_KIT);
        assertThat(testBike.getAllBallsULSBearingKit()).isEqualTo(UPDATED_ALL_BALLS_ULS_BEARING_KIT);
        assertThat(testBike.getAllBallsSBSealKit()).isEqualTo(UPDATED_ALL_BALLS_SB_SEAL_KIT);
        assertThat(testBike.getPivotWorksSTBearingKit()).isEqualTo(UPDATED_PIVOT_WORKS_ST_BEARING_KIT);
        assertThat(testBike.getPivotWorksSRebuildKit()).isEqualTo(UPDATED_PIVOT_WORKS_S_REBUILD_KIT);
        assertThat(testBike.getMpForkSealDriver()).isEqualTo(UPDATED_MP_FORK_SEAL_DRIVER);
        assertThat(testBike.getMpValveSealInstallTool()).isEqualTo(UPDATED_MP_VALVE_SEAL_INSTALL_TOOL);
        assertThat(testBike.getWinderosaGasketKitTopEnd()).isEqualTo(UPDATED_WINDEROSA_GASKET_KIT_TOP_END);
        assertThat(testBike.getWinderosaGasketKitOilSeals()).isEqualTo(UPDATED_WINDEROSA_GASKET_KIT_OIL_SEALS);
        assertThat(testBike.getOemExhaustGasket()).isEqualTo(UPDATED_OEM_EXHAUST_GASKET);
        assertThat(testBike.getWinderosaGasketExhaust()).isEqualTo(UPDATED_WINDEROSA_GASKET_EXHAUST);
        assertThat(testBike.getWinderosaWaterPumpRebuildKit()).isEqualTo(UPDATED_WINDEROSA_WATER_PUMP_REBUILD_KIT);
        assertThat(testBike.getHotRodsConnectingRodKit()).isEqualTo(UPDATED_HOT_RODS_CONNECTING_ROD_KIT);
        assertThat(testBike.getHotRodsCounterBalRebuildKit()).isEqualTo(UPDATED_HOT_RODS_COUNTER_BAL_REBUILD_KIT);
        assertThat(testBike.getHotRodsBERebuildKit()).isEqualTo(UPDATED_HOT_RODS_BE_REBUILD_KIT);
        assertThat(testBike.getHotRodsBERebuildKitSt()).isEqualTo(UPDATED_HOT_RODS_BE_REBUILD_KIT_ST);
        assertThat(testBike.getHotRodsCylinderHead()).isEqualTo(UPDATED_HOT_RODS_CYLINDER_HEAD);
        assertThat(testBike.getHotRodsMainBearingSealKit()).isEqualTo(UPDATED_HOT_RODS_MAIN_BEARING_SEAL_KIT);
        assertThat(testBike.getHotRodsTransmissionBearings()).isEqualTo(UPDATED_HOT_RODS_TRANSMISSION_BEARINGS);
        assertThat(testBike.getHotRodsWristPinBearings()).isEqualTo(UPDATED_HOT_RODS_WRIST_PIN_BEARINGS);
        assertThat(testBike.getHotRodsSOHCCamshaftStage1()).isEqualTo(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_1);
        assertThat(testBike.getHotRodsSOHCCamshaftStage2()).isEqualTo(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_2);
        assertThat(testBike.getHotRodsSOHCCamshaftStage3()).isEqualTo(UPDATED_HOT_RODS_SOHC_CAMSHAFT_STAGE_3);
        assertThat(testBike.getHotRodsDOHCCamshaftStage1Intake()).isEqualTo(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_INTAKE);
        assertThat(testBike.getHotRodsDOHCCamshaftStage1Exhaust()).isEqualTo(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_1_EXHAUST);
        assertThat(testBike.getHotRodsDOHCCamshaftStage2Intake()).isEqualTo(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_INTAKE);
        assertThat(testBike.getHotRodsDOHCCamshaftStage2Exhaust()).isEqualTo(UPDATED_HOT_RODS_DOHC_CAMSHAFT_STAGE_2_EXHAUST);
    }

    @Test
    @Transactional
    public void updateNonExistingBike() throws Exception {
        int databaseSizeBeforeUpdate = bikeRepository.findAll().size();

        // Create the Bike
        BikeDTO bikeDTO = bikeMapper.toDto(bike);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBikeMockMvc.perform(put("/api/bikes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(bikeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Bike in the database
        List<Bike> bikeList = bikeRepository.findAll();
        assertThat(bikeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBike() throws Exception {
        // Initialize the database
        bikeRepository.saveAndFlush(bike);

        int databaseSizeBeforeDelete = bikeRepository.findAll().size();

        // Get the bike
        restBikeMockMvc.perform(delete("/api/bikes/{id}", bike.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Bike> bikeList = bikeRepository.findAll();
        assertThat(bikeList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Bike.class);
        Bike bike1 = new Bike();
        bike1.setId(1L);
        Bike bike2 = new Bike();
        bike2.setId(bike1.getId());
        assertThat(bike1).isEqualTo(bike2);
        bike2.setId(2L);
        assertThat(bike1).isNotEqualTo(bike2);
        bike1.setId(null);
        assertThat(bike1).isNotEqualTo(bike2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BikeDTO.class);
        BikeDTO bikeDTO1 = new BikeDTO();
        bikeDTO1.setId(1L);
        BikeDTO bikeDTO2 = new BikeDTO();
        assertThat(bikeDTO1).isNotEqualTo(bikeDTO2);
        bikeDTO2.setId(bikeDTO1.getId());
        assertThat(bikeDTO1).isEqualTo(bikeDTO2);
        bikeDTO2.setId(2L);
        assertThat(bikeDTO1).isNotEqualTo(bikeDTO2);
        bikeDTO1.setId(null);
        assertThat(bikeDTO1).isNotEqualTo(bikeDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(bikeMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(bikeMapper.fromId(null)).isNull();
    }
}
