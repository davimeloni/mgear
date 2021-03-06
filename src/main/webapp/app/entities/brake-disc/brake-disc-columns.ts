let allCols = [
    {group: '', field: 'id', label: 'ID', display: true},
{group: '', field: 'sku', label: 'SKU', display: true},
{group: '', field: 'active', label: 'Active', display: true},
{group: '', field: 'au', label: 'Au', display: true},
{group: '', field: 'de', label: 'De', display: true},
{group: '', field: 'metalGearvisibility', label: 'MetalGear Visibility', display: true},
{group: '', field: 'bikematevisibility', label: 'Bikemate Visibility', display: true},
{group: '', field: 'mgiVisibility', label: 'Mgi Visibility', display: true},
{group: '', field: 'discStatus', label: 'Disc Status', display: true},
{group: '', field: 'productGroup1', label: 'Product Group 1', display: true},
{group: '', field: 'productGroup2', label: 'Product Group 2', display: true},
{group: '', field: 'fitment', label: 'Fitment', display: true},
{group: '', field: 'description', label: 'Description', display: true},
{group: '', field: 'unit', label: 'Unit', display: true},
{group: '', field: 'qty', label: 'Qty', display: true},
{group: '', field: 'brand', label: 'Brand', display: true},
{group: '', field: 'biketypes', label: 'Biketypes', display: true},
{group: '', field: 'models2012on', label: 'Models 2012 On', display: true},
{group: '', field: 'gS1EANNo', label: 'GS1 EAN', display: true},
{group: '', field: 'ourNotes', label: 'Our Notes', display: true},
{group: '', field: 'weight', label: 'Weight', display: true},
{group: '', field: 'packType', label: 'Pack Type', display: true},
{group: '', field: 'packLength', label: 'Pack Length', display: true},
{group: '', field: 'packHeight', label: 'Pack Height', display: true},
{group: '', field: 'packWidth', label: 'Pack Width', display: true},
{group: '', field: 'packCubic', label: 'Pack Cubic', display: true},
{group: '', field: 'oD', label: 'OD', display: true},
{group: '', field: 'bHC', label: 'BHC', display: true},
{group: '', field: 'bHQty', label: 'BH Qty', display: true},
{group: '', field: 'bHSize', label: 'BH Size', display: true},
{group: '', field: 'bHOD', label: 'BH OD', display: true},
{group: '', field: 'bHStep', label: 'BH Step', display: true},
{group: '', field: 'bHType', label: 'BH Type', display: true},
{group: '', field: 'thickness', label: 'Thickness', display: true},
{group: '', field: 'thicknessMin', label: 'Thickness Min', display: true},
{group: '', field: 'offset', label: 'Offset', display: true},
{group: '', field: 'brakeAreawidth', label: 'Brake Areawidth', display: true},
{group: '', field: 'tUVLHC', label: 'TUV/LHC', display: true},
{group: '', field: 'customerNotes', label: 'Customer Notes', display: true},
{group: '', field: 'eListing', label: 'E Listing', display: true},
{group: '', field: 'eforMake', label: 'E for Make', display: true},
{group: '', field: 'eDate', label: 'E Date', display: true},
{group: '', field: 'euploadedNeto', label: 'E uploaded Neto', display: true},
{group: '', field: 'echeck', label: 'E check', display: true},
{group: '', field: 'euploadedeBay', label: 'E uploaded eBay', display: true},
{group: '', field: 'ebayactive', label: 'Ebayactive', display: true},
{group: '', field: 'ePhotobucket', label: 'E Photobucket', display: true},
{group: '', field: 'ePhoto1', label: 'E Photo 1', display: true},
{group: '', field: 'ePhoto2', label: 'E Photo 2', display: true},
{group: '', field: 'ePhoto3', label: 'E Photo 3', display: true},
{group: '', field: 'saleStatus', label: 'Sale Status', display: true},
{group: '', field: 'rRP', label: 'RRP', display: true},
{group: '', field: 'trade1', label: 'Trade 1', display: true},
{group: '', field: 'eBAY', label: 'eBay', display: true},
{group: '', field: 'trade2', label: 'Trade 2', display: true},
{group: '', field: 'trade3', label: 'Trade 3', display: true},
{group: '', field: 'distributorNZAUD', label: 'Distributor NZAUD', display: true},
{group: '', field: 'distributorEUR', label: 'Distributor EUR', display: true},
{group: '', field: 'distributorUSD', label: 'Distributor USD', display: true},
{group: '', field: 'sPriority', label: 'S Priority', display: true},
{group: '', field: 'samplefrom', label: 'Sample from', display: true},
{group: '', field: 'requestedfrom', label: 'Requested from', display: true},
{group: '', field: 'date', label: 'Date', display: true},
{group: '', field: 'received', label: 'Received', display: true},
{group: '', field: 'camefrom', label: 'Came from', display: true},
{group: '', field: 'paidfor', label: 'Paid for', display: true},
{group: '', field: 'sentto', label: 'Sent to', display: true},
{group: '', field: 'shipNo', label: 'Ship No', display: true},
{group: '', field: 'datesent', label: 'Date sent', display: true},
{group: '', field: 'samplereturn', label: 'Sample return', display: true},
{group: '', field: 'make', label: 'Make', display: true},
{group: '', field: 'model', label: 'Model', display: true},
{group: '', field: 'year', label: 'Year', display: true},
{group: '', field: 'sampleFitment', label: 'Sample Fitment', display: true},
{group: '', field: 'oEM', label: 'OEM', display: true},
{group: '', field: 'notesforProduction', label: 'Notes for Production', display: true},
{group: '', field: 'productionCode', label: 'Production Code', display: true},
{group: '', field: 'hAPapproved', label: 'HAP approved', display: true},
{group: '', field: 'sHAapproved', label: 'SHA approved', display: true},
{group: '', field: 'approvedby', label: 'Approved by', display: true},
{group: '', field: 'notestoDrawing', label: 'Notes to Drawing', display: true},
{group: '', field: 'filename', label: 'Filename', display: true},
{group: '', field: 'cOSTUSD', label: 'COST USD', display: true},
{group: '', field: 'centrecolour', label: 'Centrecolour', display: true},
{group: '', field: 'laser', label: 'Laser', display: true},
{group: '', field: 'qTY1', label: 'QTY 1', display: true},
{group: '', field: 'uSD', label: 'USD', display: true},
{group: '', field: 'completeProduction', label: 'Complete Production', display: true},
{group: '', field: 'ourNotetoProduction', label: 'Our Note to Production', display: true},
];

export default allCols;