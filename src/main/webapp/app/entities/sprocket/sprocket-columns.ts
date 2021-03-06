let allCols = [
    {group: '', field: 'id', label: 'ID', display: true},
    {group: '', field: 'sku', label: 'SKU', display: true},
    {group: '', field: 'active', label: 'Active', display: true},
    {group: '', field: 'au', label: 'Au', display: true},
    {group: '', field: 'de', label: 'De', display: true},
    {group: '', field: 'metalGearvisibility', label: 'MetalGear Visibility', display: true},
    {group: '', field: 'bikematevisibility', label: 'Bikemate Visibility', display: true},
    {group: '', field: 'mgiVisibility', label: 'Mgi Visibility', display: true},
    {group: '', field: 'status', label: 'Status', display: true},
    {group: '', field: 'productGroup1', label: 'Product Group 1', display: true},
    {group: '', field: 'productGroup2', label: 'Product Group 2', display: true},
    {group: '', field: 'countries', label: 'Countries', display: true},
    {group: '', field: 'fitment', label: 'Fitment', display: true},
    {group: '', field: 'description', label: 'Description', display: true},
    {group: '', field: 'unit', label: 'Unit', display: true},
    {group: '', field: 'qty', label: 'Qty', display: true},
    {group: '', field: 'brand', label: 'Brand', display: true},
    {group: '', field: 'biketypes', label: 'Biketypes', display: true},
    {group: '', field: 'fitsMakes', label: 'Fits Makes', display: true},
    {group: '', field: 'modelsupto', label: 'Modelsupto', display: true},
    {group: '', field: 'gS1EAN', label: 'GS1 EAN', display: true},
    {group: '', field: 'ourNotes', label: 'Our Notes', display: true},
    {group: '', field: 'customerNotes', label: 'Customer Notes', display: true},
    {group: '', field: 'weightkg', label: 'Weight kg', display: true},
    {group: '', field: 'packType', label: 'Pack Type', display: true},
    {group: '', field: 'packLength', label: 'Pack Length', display: true},
    {group: '', field: 'packWidth', label: 'Pack Width', display: true},
    {group: '', field: 'packHeight', label: 'Pack Height', display: true},
    {group: '', field: 'packCubic', label: 'Pack Cubic', display: true},
    {group: '', field: 'sprocketChainSize', label: 'Sprocket Chain Size', display: true},
    {group: '', field: 'sprocketTeeth', label: 'Sprocket Teeth', display: true},
    {group: '', field: 'eSBHC', label: 'ES BHC', display: true},
    {group: '', field: 'eSID', label: 'ES ID', display: true},
    {group: '', field: 'eSIDinnerTeeth', label: 'ES ID inner Teeth', display: true},
    {group: '', field: 'eSBHQty', label: 'ES BH Qty', display: true},
    {group: '', field: 'eSBHSize', label: 'ES BH Size', display: true},
    {group: '', field: 'eSBHType', label: 'ES BH Type', display: true},
    {group: '', field: 'eSWidth', label: 'ES Width', display: true},
    {group: '', field: 'tolistonEbay', label: 'Toliston Ebay', display: true},
    {group: '', field: 'eListing', label: 'E Listing', display: true},
    {group: '', field: 'eforMake', label: 'E for Make', display: true},
    {group: '', field: 'euploadedNeto', label: 'E uploaded Neto', display: true},
    {group: '', field: 'eDate', label: 'E Date', display: true},
    {group: '', field: 'echeck', label: 'E check', display: true},
    {group: '', field: 'euploadedeBay', label: 'E uploaded eBay', display: true},
    {group: '', field: 'eBayactive', label: 'eBay active', display: true},
    {group: '', field: 'ePhotobucket', label: 'E Photobucket', display: true},
    {group: '', field: 'ePhotoMain', label: 'E Photo Main', display: true},
    {group: '', field: 'ePhotoClear', label: 'E Photo Clear', display: true},
    {group: '', field: 'ePhotoSide', label: 'E Photo Side', display: true},
    {group: '', field: 'salesStatus', label: 'Sales Status', display: true},
    {group: '', field: 'rRP', label: 'RRP', display: true},
    {group: '', field: 'eBay', label: 'eBay', display: true},
    {group: '', field: 'trade1', label: 'Trade 1', display: true},
    {group: '', field: 'trade2', label: 'Trade 2', display: true},
    {group: '', field: 'trade3', label: 'Trade 3', display: true},
    {group: '', field: 'distributorNZAUD', label: 'Distributor NZAUD', display: true},
    {group: '', field: 'distributorUSD', label: 'Distributor USD', display: true},
    {group: '', field: 'distributorEUR', label: 'Distributor EUR', display: true},
    {group: '', field: 'bikemateAUD', label: 'Bikemate AUD', display: true},
    {group: '', field: 'compMetalGear', label: 'Comp Metal Gear', display: true},
    {group: '', field: 'compMogema', label: 'Comp Mogema', display: true},
    {group: '', field: 'compJT', label: 'Comp JT', display: true},
    {group: '', field: 'jTBHC', label: 'JT BHC', display: true},
    {group: '', field: 'jTID', label: 'JT ID', display: true},
    {group: '', field: 'jTIDinnerTeeth', label: 'JT ID inner Teeth', display: true},
    {group: '', field: 'jTBHQty', label: 'JT BH Qty', display: true},
    {group: '', field: 'jTBHSize', label: 'JT BH Size', display: true},
    {group: '', field: 'jTBHType', label: 'JT BH Type', display: true},
    {group: '', field: 'jTWidth', label: 'JT Width', display: true},
    {group: '', field: 'jTNote', label: 'JT Note', display: true},
    {group: '', field: 'compEsjot', label: 'Comp Esjot', display: true},
    {group: '', field: 'compSuperSprox', label: 'Comp Super Sprox', display: true},
    {group: '', field: 'stock', label: 'Stock', display: true},
    {group: '', field: 'minStock', label: 'Min Stock', display: true},
    {group: '', field: 'maxStock', label: 'Max Stock', display: true},
    {group: '', field: 'supplier', label: 'Supplier', display: true},
    {group: '', field: 'supplierCode', label: 'Supplier Code', display: true},
    {group: '', field: 'supplierCurrency', label: 'Supplier Currency', display: true},
    {group: '', field: 'supplierCost', label: 'Supplier Cost', display: true},
    
];

export default allCols;
