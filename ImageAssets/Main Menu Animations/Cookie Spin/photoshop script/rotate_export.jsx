#target photoshop

var doc = app.activeDocument;
var saveFolder = Folder.selectDialog("Select folder to save rotated PNGs");

// Make sure the layer is a Smart Object and centered
if (!doc.activeLayer.isBackgroundLayer && doc.activeLayer.kind == LayerKind.SMARTOBJECT) {
    for (var i = 0; i < 360; i++) {
        doc.activeLayer.rotate(1, AnchorPosition.MIDDLECENTER); // rotate 1 degree

        var fileName = "frame_" + ("000" + i).slice(-3) + ".png";
        var filePath = new File(saveFolder + "/" + fileName);

        var opts = new PNGSaveOptions();
        opts.compression = 9;
        opts.interlaced = false;

        doc.saveAs(filePath, opts, true, Extension.LOWERCASE);
    }
} else {
    alert("Please convert the active layer to a Smart Object first!");
}
