 let allCols = [
        { group: '', field: 'id', label: 'ID', display: false },
        { group: 'Bike Model Info', field: 'visibilityAU', label: 'Visibility AU', display: true },
        { group: 'Bike Model Info', field: 'visibilityEU', label: 'Visibility EU', display: true },
        { group: 'Bike Model Info', field: 'inactive', label: 'Inactive', display: true },
        { group: 'Bike Model Info', field: 'oemconfirmed', label: 'OE Confirmed', display: true },
        { group: 'Bike Model Info', field: 'oesource', label: 'OE Source', display: true },
        { group: 'Bike Model Info', field: 'epid', label: 'ePID', display: true },
        { group: 'Bike Model Info', field: 'modeltype1', label: 'Model Type 1', display: true },
        { group: 'Bike Model Info', field: 'modeltype2', label: 'Model Type 2', display: true },
        { group: 'Bike Model Info', field: 'manufacturer', label: 'Manufacturer', display: true },
        { group: 'Bike Model Info', field: 'strokes', label: 'Strokes', display: true },
        { group: 'Bike Model Info', field: 'capacity', label: 'Capacity', display: true },
        { group: 'Bike Model Info', field: 'modelName', label: 'Model Name', display: true },
        { group: 'Bike Model Info', field: 'modelYearCode', label: 'Model Year Code', display: true },
        { group: 'Bike Model Info', field: 'modelTypeCode', label: 'Model Type Code', display: true },
        { group: 'Bike Model Info', field: 'year', label: 'Year', display: true },
        { group: 'Bike Model Info', field: 'finalDriveType', label: 'Final Drive Type', display: true },
        { group: '', field: 'categoryPath', label: 'Category Path', display: true },
        { group: '', field: 'modelNotes', label: 'Model Notes', display: false },
        { group: '', field: 'modelNotes2', label: 'Model Notes 2', display: false },
        { group: '', field: 'modelNotes3', label: 'Model Notes 3', display: false },
        { group: '', field: 'modelNotes4', label: 'Model Notes 4', display: false },
        { group: '', field: 'modelInfoHTML', label: 'Model Info HTML', display: true },
        { group: '', field: 'oemFrontBrakeSystemType', label: 'OEM Front Brake System Type', display: true },
        { group: 'Brake Disc', field: 'oemFrontBrakeDiscLeft', label: 'OEM Front Brake Disc Left', display: true },
        { group: 'Brake Disc', field: 'oemFrontBrakeDiscRight', label: 'OEM Front Brake Disc Right', display: true },
        { group: 'Brake Disc', field: 'oemFrontBrakeDiscBolts', label: 'OEM Front Brake Disc Bolts', display: true },
        { group: 'Brake Disc', field: 'oemFrontBDQTYPD', label: 'OEM Front Brake Disct Bolts QTY Per Disc', display: true },
        { group: 'Brake Disc', field: 'oemFrontBrakeDiscABSRing', label: 'OEM Front Brake Disc ABS Ring', display: true },
        { group: '', field: 'oemFrontBrakeCaliper1', label: 'OEM Front Brake Caliper 1', display: true },
        { group: '', field: 'oemFrontBrakeCaliper2', label: 'OEM Front Brake Caliper 2', display: true },
        { group: '', field: 'oemFrontBrakeCaliperPin', label: 'OEM Front Brake Caliper Pin', display: true },
        { group: 'Brake Pad', field: 'oemFrontBrakePadsFrontL', label: 'OEM Front Brake Pads Front L', display: true },
        { group: 'Brake Pad', field: 'oemFrontBrakePadsFrontR', label: 'OEM Front Brake Pads Front R', display: true },
        { group: '', field: 'oemFrontShoe', label: 'OEM Front Shoe', display: true },
        { group: 'Brake Disc', field: 'oemMidldleAxleBrakeDisc', label: 'OEM Midldle Axle Brake Disc', display: true },
        { group: 'Brake Pad', field: 'oemMiddleAxleBrakePads', label: 'OEM Middle Axle Brake Pads', display: true },
        { group: '', field: 'oemRearBrakeSystemType', label: 'OEM Rear Brake System Type', display: true },
        { group: 'Brake Disc', field: 'oeamRearBrakeDisc', label: 'OEM Rear Brake Disc', display: true },
        { group: 'Brake Disc', field: 'oeamRearBrakeDiscBolts', label: 'OEM Rear Brake Disc Bolts', display: true },
        { group: 'Brake Disc', field: 'oeamRearBrakeDiscBQTYPD', label: 'OEM Rear Brake Disc Bolts QTY Per Disc', display: true },
        { group: '', field: 'oemRearBrakeCaliper', label: 'OEM Rear Brake Caliper', display: true },
        { group: '', field: 'oemRearBrakeCaliperPin', label: 'OEM Rear Brake Caliper Pin', display: true },
        { group: 'Brake Pad', field: 'oemRearBrakePads1', label: 'OEM Rear Brake Pads 1', display: true },
        { group: 'Brake Pad', field: 'oemRearBrakePads2', label: 'OEM Rear Brake Pads 2', display: true },
        { group: '', field: 'oemShoeRear', label: 'OEM Shoe Rear', display: true },
        { group: '', field: 'oemShoeRear2', label: 'OEM Shoe Rear 2', display: true },
        { group: '', field: 'oemSlaveCylinder', label: 'OEM Slave Cylinder', display: true },
        { group: 'Chain Info', field: 'oemChainNo', label: 'OEM Chain No', display: true },
        { group: 'Chain Info', field: 'oemChainSize', label: 'OEM Chain Size', display: true },
        { group: 'Chain Info', field: 'oemChainLinks', label: 'OEM Chain Links', display: true },
        { group: 'Sprocket Info', field: 'oemFrontSprocket', label: 'OEM Front Sprocket', display: true },
        { group: 'Sprocket Info', field: 'oemFrontGearing', label: 'OEM Front Gearing', display: true },
        { group: 'Sprocket Info', field: 'oemFrontGearingMin', label: 'OEM Front Gearing Min', display: true },
        { group: 'Sprocket Info', field: 'oemFrontGearingMax', label: 'OEM Front Gearing Max', display: true },
        { group: 'Sprocket Info', field: 'oemRearSprocket', label: 'OEM Rear Sprocket', display: true },
        { group: 'Sprocket Info', field: 'oemRearGearing', label: 'OEM Rear Gearing', display: true },
        { group: 'Sprocket Info', field: 'oemRearGearingMin', label: 'OEM Rear Gearing Min', display: true },
        { group: 'Sprocket Info', field: 'oemRearGearingMax', label: 'OEM Rear Gearing Max', display: true },
        { group: '', field: 'finalDriveNotes', label: 'Final Drive Notes', display: true },
        { group: 'Chain Info', field: 'chainConvSize', label: 'Chain Conv Size', display: true },
        { group: 'Chain Info', field: 'chainConvLinks', label: 'Chain Conv Links', display: true },
        { group: '', field: 'oemFrontWheel', label: 'OEM Front Wheel', display: true },
        { group: '', field: 'oemFrontWheelType', label: 'OEM Front Wheel Type', display: true },
        { group: '', field: 'oemFrontWheelFront', label: 'OEM Front Wheel Front', display: true },
        { group: '', field: 'oemFrontWheelTyreSize', label: 'OEM Front Wheel Tyre Size', display: true },
        { group: '', field: 'oemFrontHub', label: 'OEM Front Hub', display: true },
        { group: '', field: 'oemFrontWheelbearing1', label: 'OEM Front Wheel Bearing 1', display: true },
        { group: '', field: 'oemFrontWheelbearing2', label: 'OEM Front Wheel Bearing 2', display: true },
        { group: '', field: 'oemFrontWheelSeal', label: 'OEM Front Wheel Seal', display: true },
        { group: '', field: 'oemRearWheel', label: 'OEM Rear Wheel', display: true },
        { group: '', field: 'oemRearWheelSize', label: 'OEM Rear Wheel Size', display: true },
        { group: '', field: 'oemRearWheelTyre', label: 'OEM Rear Wheel Tyre', display: true },
        { group: '', field: 'oemRearWheelBearing1', label: 'OEM Rear Wheel Bearing 1', display: true },
        { group: '', field: 'oemRearWheelBearing2', label: 'OEM Rear Wheel Bearing 2', display: true },
        { group: '', field: 'oemRearWheelSeal', label: 'OEM Rear Wheel Seal', display: true },
        { group: '', field: 'frontPadsDiffCaliper', label: 'Front Pads Diff Caliper', display: true },
        { group: '', field: 'qtyBH', label: 'Qty BH', display: true },
        { group: '', field: 'handbrakeParking', label: 'Handbrake Parking', display: true },
        { group: '', field: 'addNotesToBike', label: 'Add Notes To Bike', display: true },
        { group: '', field: 'dateAndID', label: 'Date And ID', display: true },
        { group: '', field: 'source', label: 'Source', display: true },
        { group: 'TUV', field: 'tuvRequired', label: 'TUV Required', display: true },
        { group: 'TUV', field: 'tuvTypeCode', label: 'TUV Type Code', display: true },
        { group: '', field: 'abekba', label: 'ABE / KBA', display: true },
        { group: 'TUV', field: 'tuvFrontDisc', label: 'TUV Front Disc', display: true },
        { group: 'TUV', field: 'tuvRearDisc', label: 'TUV Rear Disc', display: true },
        { group: 'Brake Disc', field: 'bremboBrakeDiscFrontRef', label: 'Brembo Brake Disc Front Ref', display: true },
        { group: 'Brake Disc', field: 'ebcBrakeDiscFrontRef', label: 'EBC Brake Disc Front Ref', display: true },
        { group: 'Brake Disc', field: 'TRWBrakeDiscFrontRef', label: 'TRW Brake Disc Front Ref', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFrontLeftRef', label: 'MGEAR Brake Disc Front Left Ref', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFrontRightRef', label: 'MGEAR Brake Disc Front Right Ref', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFrontCheck', label: 'MGEAR Brake Disc Front Check', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFrontLeftRef2', label: 'MGEAR Brake Disc Front Left Ref 2', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFrontRightRef2', label: 'MGEAR Brake Disc Front Right Ref 2', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscFNeto', label: 'MGEAR Brake Disc F Neto', display: true },
        { group: 'Brake Disc', field: 'motodiscBrakeDiscFNeto', label: 'Motodisc Brake Disc F Neto', display: true },
        { group: 'Brake Pad', field: 'ebcBrakePadsFrontLRef', label: 'EBC Brake Pads Front L Ref', display: true },
        { group: 'Brake Pad', field: 'ebcBrakePadsFrontRRef', label: 'EBC Brake Pads Front R Ref', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsFrontLRef', label: 'MGEAR Brake Pads Front L Ref', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsFrontRRef', label: 'MGEAR Brake Pads Front R Ref', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsFNeto', label: 'MGEAR Brake Pads F Neto', display: true },
        { group: 'Brake Pad', field: 'motoPadBrakePadsFrontLRef', label: 'Moto Pad Brake Pads Front L Ref', display: true },
        { group: 'Brake Pad', field: 'motoPadBrakePadsFrontRRef', label: 'Moto Pad Brake Pads Front R Ref', display: true },
        { group: 'Brake Pad', field: 'motopadBrakePadsFNeto', label: 'Motopad Brake Pads F Neto', display: true },
        { group: 'All Balls', field: 'allBallsFCRebuildKit1', label: 'All Balls Front Caliper Rebuild Kit 1', display: true },
        { group: 'All Balls', field: 'allBallsFCPin', label: 'All Balls Front Caliper Pin', display: true },
        { group: 'All Balls', field: 'allBallsFMCyRebuildKit', label: 'All Balls Front Master Cylinder Rebuild Kit', display: true },
        { group: 'All Balls', field: 'allBallsFSCRebuildKit', label: 'All Balls Front Slave Cylinder Rebuild Kit', display: true },
        { group: '', field: 'newfrenShoeFront', label: 'Newfren Shoe Front', display: true },
        { group: 'Brake Disc', field: 'mgearMiddleAxleBrakeDiscNeto', label: 'MGEAR Middle Axle Brake Disc Neto', display: true },
        { group: 'Brake Disc', field: 'mgearMiddleAxleBrakeDiscNeto2', label: 'MGEAR Middle Axle Brake Disc Neto 2', display: true },
        { group: 'Brake Pad', field: 'mgearMiddleAxleBrakePadNeto', label: 'MGEAR Middle Axle Brake Pad Neto', display: true },
        { group: 'Brake Pad', field: 'mgearMiddleAxleBrakePadNeto2', label: 'MGEAR Middle Axle Brake Pad Neto 2', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsParkRef', label: 'MGEAR Brake Pads Park Ref', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsParkRef2', label: 'MGEAR Brake Pads Park Ref 2', display: true },
        { group: 'Brake Disc', field: 'ebcBrakeDiscRearRef', label: 'EBC Brake Disc Rear Ref', display: true },
        { group: 'Brake Disc', field: 'bremboBrakeDiscRearRef', label: 'Brembo Brake Disc Rear Ref', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscRearRef', label: 'MGEAR Brake Disc Rear Ref', display: true },
        { group: 'Brake Disc', field: 'TRWBrakeDiscRearRef', label: 'TRW Brake Disc Rear Ref', display: true },
        { group: 'Brake Disc', field: 'mgearBrakeDiscRear', label: 'MGEAR Brake Disc Rear', display: true },
        { group: 'All Balls', field: 'allBallsRCRebuildKit1', label: 'All Balls Rear Caliper Rebuild Kit 1', display: true },
        { group: 'All Balls', field: 'allBallsRearCaliperBolt', label: 'All Balls Rear Caliper Bolt', display: true },
        { group: 'All Balls', field: 'allBallsRMCrRebuildKit', label: 'All Balls Rear Master Cylinder Rebuild Kit', display: true },
        { group: 'Brake Pad', field: 'ebcBrakePadsRearRef', label: 'EBC Brake Pads Rear Ref', display: true },
        { group: 'Brake Pad', field: 'mgearBrakePadsRearNeto', label: 'MGEAR Brake Pads Rear Neto', display: true },
        { group: '', field: 'newfrenShoeRear', label: 'Newfren Shoe Rear', display: true },
        { group: 'All Balls', field: 'allBallsRearBrakePedalKit', label: 'All Balls Rear Brake Pedal Kit', display: true },
        { group: 'All Balls', field: 'allBallsCSCRebuildKit', label: 'All Balls Clutch Slave Cylinder Rebuild Kit', display: true },
        { group: 'Chain Info', field: 'chains', label: 'Chain SKUs', display: true },
        { group: 'Sprocket Info', field: 'frontJTRefFront', label: 'Front JT Ref Front', display: true },
        { group: 'Sprocket Info', field: 'esjotRefFront', label: 'Esjot Ref Front', display: true },
        { group: 'Sprocket Info', field: 'mgearRefFront', label: 'MGEAR Ref Front', display: true },
        { group: 'Sprocket Info', field: 'mogemaRefFront', label: 'Mogema Ref Front', display: true },
        { group: 'Sprocket Info', field: 'supersproxRefFront', label: 'Supersprox Ref Front', display: true },
        { group: 'Sprocket Info', field: 'bikeFrontSprockets', label: 'Front Sprocket SKUs', display: true },
        { group: 'Sprocket Info', field: 'esjotRefRear', label: 'Esjot Ref Rear', display: true },
        { group: 'Sprocket Info', field: 'jtRefRear', label: 'Jt Ref Rear', display: true },
        { group: 'Sprocket Info', field: 'mgearRefRear', label: 'MGEAR Ref Rear', display: true },
        { group: 'Sprocket Info', field: 'mogemaRefRear', label: 'Mogema Ref Rear', display: true },
        { group: 'Sprocket Info', field: 'supersproxRefRear', label: 'Supersprox Ref Rear', display: true },
        { group: 'Sprocket Info', field: 'bikeRearSprockets', label: 'Rear Sprocket SKUS', display: true },
        { group: 'Sprocket Info', field: 'esjotRefFrontConv', label: 'Esjot Ref Front Conv', display: true },
        { group: 'Sprocket Info', field: 'jtSprocketRef', label: 'Jt Sprocket Ref', display: true },
        { group: 'Sprocket Info', field: 'mgearRefFrontConv', label: 'MGEAR Ref Front Conv', display: true },
        { group: 'Sprocket Info', field: 'mogemarefFrontConv', label: 'Mogemaref Front Conv', display: true },
        { group: 'Sprocket Info', field: 'supersproxRefFrontConv', label: 'Supersprox Ref Front Conv', display: true },
        { group: 'Sprocket Info', field: 'conversionChain', label: 'Conversion Chain', display: true },
        { group: 'Sprocket Info', field: 'mgearSprocketRearConv', label: 'MGEAR Sprocket Rear Conv', display: true },
        { group: 'Sprocket Info', field: 'frontSprocketConvs', label: 'Front Sprocket Conv. SKUS', display: true },
        { group: 'Sprocket Info', field: 'esjotRefRearConv', label: 'Esjot Ref Rear Conv', display: true },
        { group: 'Sprocket Info', field: 'mgearRefRearConv', label: 'MGEAR Ref Rear Conv', display: true },
        { group: 'Sprocket Info', field: 'mogemaRefRearConv', label: 'Mogema Ref Rear Conv', display: true },
        { group: 'Sprocket Info', field: 'supersproxRefRearConv', label: 'Supersprox Ref Rear Conv', display: true },
        { group: 'Sprocket Info', field: 'rearSprocketConvs', label: 'Rear Sprocket CONV SKUS', display: true },
        { group: 'All Balls', field: 'allBallsFWBearingKit1', label: 'All Balls Front Wheel Bearing Kit 1', display: true },
        { group: 'All Balls', field: 'allBallsFWBearingKit2', label: 'All Balls Front Wheel Bearing Kit 2', display: true },
        { group: 'All Balls', field: 'allBallsRWBearingKit1', label: 'All Balls Rear Wheel Bearing Kit 1', display: true },
        { group: 'All Balls', field: 'allBallsRWBearingKit2', label: 'All Balls Rear Wheel Bearing Kit 2', display: true },
        { group: 'All Balls', field: 'allBallsRWBearingUpgrade', label: 'All Balls Rear Wheel Bearing Upgrade', display: true },
        { group: '', field: 'oemSparkPlug', label: 'OEM Spark Plug', display: true },
        { group: '', field: 'oemSparkPlugQTY', label: 'OEM Spark Plug QTY', display: true },
        { group: '', field: 'ngkSparkPlugSKUs', label: 'Ngk Spark Plug SKUs', display: true },
        { group: '', field: 'oemAlternator', label: 'OEM Alternator', display: true },
        { group: '', field: 'oemVoltageRegulator', label: 'OEM Voltage Regulator', display: true },
        { group: '', field: 'arrowheadAlternator', label: 'Arrowhead Alternator', display: true },
        { group: '', field: 'arrowheadAlternator2', label: 'Arrowhead Alternator 2', display: true },
        { group: '', field: 'arrowheadCDIModule', label: 'Arrowhead CDI Module', display: true },
        { group: '', field: 'arrowheadChargingCoil', label: 'Arrowhead Charging Coil', display: true },
        { group: '', field: 'arrowheadIgnitionCoil', label: 'Arrowhead Ignition Coil', display: true },
        { group: '', field: 'arrowheadStatorCoil', label: 'Arrowhead Stator Coil', display: true },
        { group: '', field: 'arrowheadVoltageRegulator', label: 'Arrowhead Voltage Regulator', display: true },
        { group: '', field: 'arrowheadPowerShiftCM', label: 'Arrowhead Power Shift Control Monitor', display: true },
        { group: '', field: 'arrowheadStarterDrive', label: 'Arrowhead Starter Drive', display: true },
        { group: '', field: 'arrowheadStarterMotor', label: 'Arrowhead Starter Motor', display: true },
        { group: '', field: 'arrowheadStarterRelay', label: 'Arrowhead Starter Relay', display: true },
        { group: '', field: 'oemBattery', label: 'OEM Battery', display: true },
        { group: '', field: 'ssbAGMBattery', label: 'SSB AGM Battery', display: true },
        { group: '', field: 'oemAirFilter', label: 'OEM Air Filter', display: true },
        { group: '', field: 'knAirFilter', label: 'K&N Air Filter', display: true },
        { group: '', field: 'motorexAirFilter', label: 'Motorex Air Filter', display: true },
        { group: '', field: 'motorexAirFilterPreoiled', label: 'Motorex Air Filter Pre-oiled', display: true },
        { group: '', field: 'oemOilFilter1', label: 'OEM Oil Filter 1', display: true },
        { group: '', field: 'knOilFilter1', label: 'K&N Oil Filter 1', display: true },
        { group: '', field: 'oemOilFilter2', label: 'OEM Oil Filter 2', display: true },
        { group: '', field: 'knOilFilter2', label: 'K&N Oil Filter 2', display: true },
        { group: '', field: 'motionProOilFilterMagnet', label: 'Motion Pro Oil Filter Magnet', display: true },
        { group: '', field: 'oemSteeringBearing', label: 'OEM Steering Bearing', display: true },
        { group: '', field: 'oemSteeringSeal', label: 'OEM Steering Seal', display: true },
        { group: 'All Balls', field: 'allBallsSBSealKit1', label: 'All Balls Steering Bearing & Seal Kit 1', display: true },
        { group: 'All Balls', field: 'allBallsSBSealKit2', label: 'All Balls Steering Bearing & Seal Kit 2', display: true },
        { group: 'All Balls', field: 'allBallsSBSealKitLower', label: 'All Balls Steering Bearing & Seal Kit Lower', display: true },
        { group: 'All Balls', field: 'allBallsSBSealKitLower2', label: 'All Balls Steering Bearing & Seal Kit Lower 2', display: true },
        { group: 'All Balls', field: 'allBallsCBSealKit', label: 'All Balls Crank Bearing & Seal Kit', display: true },
        { group: '', field: 'oemForkAssemblyLeft', label: 'OEM Fork Assembly Left', display: true },
        { group: '', field: 'oemForkAssemblyRight', label: 'OEM Fork Assembly Right', display: true },
        { group: '', field: 'oemForkSeals', label: 'OEM Fork Seals', display: true },
        { group: 'All Balls', field: 'allBallsForkSeals', label: 'All Balls Fork Seals', display: true },
        { group: '', field: 'xprForkSeals', label: 'XRP Fork Seals', display: true },
        { group: 'All Balls', field: 'allBallsForkBushingKit', label: 'All Balls Fork Bushing Kit', display: true },
        { group: '', field: 'motionProMicroForkBleeder', label: 'Motion Pro Micro Fork Bleeder', display: true },
        { group: '', field: 'motionProCRProThottleKit', label: 'Motion Pro CR Pro Thottle Kit', display: true },
        { group: '', field: 'oemCableSpeedo', label: 'OEM Cable Speedo', display: true },
        { group: '', field: 'motionProCableSpeedo', label: 'Motion Pro Cable Speedo', display: true },
        { group: '', field: 'motionProCableThrottleTube', label: 'Motion Pro Cable Throttle Tube', display: true },
        { group: '', field: 'crossproRadiatorGuard', label: 'Crosspro Radiator Guard', display: true },
        { group: '', field: 'oemClutchFibres', label: 'OEM Clutch Fibres', display: true },
        { group: '', field: 'oemClutchFibresSteels', label: 'OEM Clutch Fibres & Steels', display: true },
        { group: '', field: 'newfrenClutchKit', label: 'Newfren Clutch Kits', display: true},
    { group: '', field: 'newfrenClutchSpringKits', label: 'Newfren Clutch Spring Kits', display: true },
        { group: 'All Balls', field: 'allBallsCMCRebuiltKit', label: 'All Balls Clutch Master Cylinder Rebuilt Kit', display: true },
        { group: '', field: 'wisecoForgedClutchBasket', label: 'Wiseco Forged Clutch Basket', display: true },
        { group: '', field: 'wisecoBottemEndRebuildKit', label: 'Wiseco Bottem End Rebuild Kit', display: true },
        { group: '', field: 'wrenchRERebuildKit', label: 'Wrench Rabbit Engine Rebuild Kit', display: true },
        { group: '', field: 'oemCarbAssembly', label: 'OEM Carb Assembly', display: true },
        { group: 'All Balls', field: 'allBallsCarbRepairKit', label: 'All Balls Carb Repair Kit', display: true },
        { group: 'All Balls', field: 'allBallsCRMidBodyGasket1', label: 'All Balls Carb Repair Mid Body Gasket 1', display: true },
        { group: 'All Balls', field: 'allBallsCRMidBodyGasket2', label: 'All Balls Carb Repair Mid Body Gasket 2', display: true },
        { group: 'All Balls', field: 'allBallsFuelTapRepairKit', label: 'All Balls Fuel Tap Repair Kit', display: true },
        { group: 'All Balls', field: 'allBallsFuelTapRepairKit2', label: 'All Balls Fuel Tap Repair Kit 2', display: true },
        { group: '', field: 'fuelStarFuelValveKit', label: 'Fuel Star Fuel Valve Kit', display: true },
        { group: '', field: 'fuelStarFuelValveKit2', label: 'Fuel Star Fuel Valve Kit 2', display: true },
        { group: '', field: 'fuelStarHoseClampKit', label: 'Fuel Star Hose & Clamp Kit', display: true },
        { group: '', field: 'rgEngineCoverLHS', label: 'R&G Engine Cover LHS', display: true },
        { group: '', field: 'rgTailTidy', label: 'R&G Tail Tidy', display: true },
        { group: 'All Balls', field: 'allBallsLBSealKit', label: 'All Balls Linkage Bearing & Seal Kit', display: true },
        { group: 'All Balls', field: 'allBallsLRSBearingKit', label: 'All Balls Lower Rear Shock Bearing Kit', display: true },
        { group: 'All Balls', field: 'allBallsURSBearingKit', label: 'All Balls Upper Rear Shock Bearing Kit', display: true },
        { group: 'All Balls', field: 'allBallsULSBearingKit', label: 'All Balls Upper & Lower Shock Bearing Kit', display: true },
        { group: 'All Balls', field: 'allBallsSBSealKit', label: 'All Balls Swingarm Bearing & Seal Kit', display: true },
        { group: '', field: 'pivotWorksSTBearingKit', label: 'Pivot Works Shock Thrust Bearing Kit', display: true },
        { group: '', field: 'pivotWorksSRebuildKit', label: 'Pivot Works Shock Rebuild Kit', display: true },
        { group: '', field: 'mpForkSealDriver', label: 'MP Fork Seal Driver', display: true },
        { group: '', field: 'mpValveSealInstallTool', label: 'MP Valve Seal Install Tool', display: true },
        { group: '', field: 'winderosaGasketKitTopEnd', label: 'Winderosa Gasket Kit Top End', display: true },
        { group: '', field: 'winderosaGasketKitOilSeals', label: 'Winderosa Gasket Kit Complete wtth Oil Seals', display: true },
        { group: '', field: 'oemExhaustGasket', label: 'OEM Exhaust Gasket', display: true },
        { group: '', field: 'winderosaGasketExhaust', label: 'Winderosa Gasket Exhaust', display: true },
        { group: '', field: 'winderosaWaterPumpRebuildKit', label: 'Winderosa Water Pump Rebuild Kit', display: true },
        { group: '', field: 'hotRodsConnectingRodKit', label: 'Hot Rods Connecting Rod Kit', display: true },
        { group: '', field: 'hotRodsCounterBalRebuildKit', label: 'Hot Rods Counter Balance Rebuild Kit', display: true },
        { group: '', field: 'hotRodsBERebuildKit', label: 'Hot Rods Bottom End Rebuild Kit', display: true },
        { group: '', field: 'hotRodsBERebuildKitSt', label: 'Hot Rods Bottom End Rebuild Kit Stroker', display: true },
        { group: '', field: 'hotRodsCylinderHead', label: 'Hot Rods Cylinder Head', display: true },
        { group: '', field: 'hotRodsMainBearingSealKit', label: 'Hot Rods Main Bearing & Seal Kit', display: true },
        { group: '', field: 'hotRodsTransmissionBearings', label: 'Hot Rods Transmission Bearings', display: true },
        { group: '', field: 'hotRodsWristPinBearings', label: 'Hot Rods Wrist Pin Bearings', display: true },
        { group: '', field: 'hotRodsSOHCCamshaftStage1', label: 'Hot Rods SOHC Camshaft Stage 1', display: true },
        { group: '', field: 'hotRodsSOHCCamshaftStage2', label: 'Hot Rods SOHC Camshaft Stage 2', display: true },
        { group: '', field: 'hotRodsSOHCCamshaftStage3', label: 'Hot Rods SOHC Camshaft Stage 3', display: true },
        { group: '', field: 'hotRodsDOHCCamshaftStage1Intake', label: 'Hot Rods DOHC Camshaft Stage 1 Intake', display: true },
        { group: '', field: 'hotRodsDOHCCamshaftStage1Exhaust', label: 'Hot Rods DOHC Camshaft Stage 1 Exhaust', display: true },
        { group: '', field: 'hotRodsDOHCCamshaftStage2Intake', label: 'Hot Rods DOHC Camshaft Stage 2 Intake', display: true },
        { group: '', field: 'hotRodsDOHCCamshaftStage2Exhaust', label: 'Hot Rods DOHC Camshaft Stage 2 Exhaust', display: true },
        { group: '', field: 'bikeFrontSprockets', label: 'Bike Front Sprocket', display: true },
        { group: '', field: 'bikeRearSprockets', label: 'Bike Rear Sprocket', display: true },
        { group: '', field: 'rearSprocketConvs', label: 'Rear Sprocket Conv', display: true },
        { group: '', field: 'frontSprocketConvs', label: 'Front Sprocket Conv', display: true },
        { group: '', field: 'chains', label: 'Chain', display: true },
        { group: 'Brake Pad', field: 'bikeBrakePads', label: 'Bike Brake Pad', display: true },
        { group: 'Brake Disc', field: 'bikeBrakeDiscs', label: 'Bike Brake Disc', display: true },
    ];

export default allCols;