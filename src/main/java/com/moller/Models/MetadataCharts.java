package com.moller.Models;

import org.apache.commons.imaging.formats.tiff.constants.TiffTagConstants;
import org.apache.commons.imaging.formats.tiff.taginfos.TagInfoLong;

public class MetadataCharts {
    public static MetadataObject[] GetExifDirectory() {
        return new MetadataObject[] {
                new MetadataObject(0x0001, "InteropIndex", null),
                new MetadataObject(0x0002, "InteropVersion", null),
                new MetadataObject(0x000b, "ProcessingSoftware", null),
                new MetadataObject(0x00fe, "NewSubfileType", TiffTagConstants.TIFF_TAG_NEW_SUBFILE_TYPE),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x00ff, "OldSubfileType", null),
                new MetadataObject(0x0100, "ImageWidth", TiffTagConstants.TIFF_TAG_IMAGE_WIDTH),
                new MetadataObject(0x0101, "ImageHeight", TiffTagConstants.TIFF_TAG_IMAGE_LENGTH),
                new MetadataObject(0x0102, "BitsPerSample", TiffTagConstants.TIFF_TAG_BITS_PER_SAMPLE),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0103, "Compression", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0106, "PhotometicInterpretation", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0107, "Thresholding", null),
                new MetadataObject(0x0108, "CellWidth", TiffTagConstants.TIFF_TAG_CELL_WIDTH),
                new MetadataObject(0x0109, "CellLength", TiffTagConstants.TIFF_TAG_CELL_LENGTH),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x010a, "FillOrder", null),
                new MetadataObject(0x010d, "DocumentName", TiffTagConstants.TIFF_TAG_DOCUMENT_NAME),
                new MetadataObject(0x010e, "ImageDescription", TiffTagConstants.TIFF_TAG_IMAGE_DESCRIPTION),
                new MetadataObject(0x010f, "Make", TiffTagConstants.TIFF_TAG_MAKE),
                new MetadataObject(0x0110, "Model", TiffTagConstants.TIFF_TAG_MODEL),
                new MetadataObject(0x0111, "StripOffsets",
                        TiffTagConstants.TIFF_TAG_STRIP_OFFSETS),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0112, "Orientation", null),
                new MetadataObject(0x0115, "SamplesPerPixel", TiffTagConstants.TIFF_TAG_SAMPLES_PER_PIXEL),
                new MetadataObject(0x0116, "RowsPerStrip", TiffTagConstants.TIFF_TAG_ROWS_PER_STRIP),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0117, "StripByteCounts",
                        TiffTagConstants.TIFF_TAG_STRIP_BYTE_COUNTS),
                new MetadataObject(0x0118, "MinSampleValue", TiffTagConstants.TIFF_TAG_MIN_SAMPLE_VALUE),
                new MetadataObject(0x0119, "MaxSampleValue", TiffTagConstants.TIFF_TAG_MAX_SAMPLE_VALUE),
                new MetadataObject(0x011a, "XResolution", TiffTagConstants.TIFF_TAG_XRESOLUTION),
                new MetadataObject(0x011b, "YResolution", TiffTagConstants.TIFF_TAG_YRESOLUTION),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x011c, "PlanarConfiguration", null),
                new MetadataObject(0x011d, "PageName", TiffTagConstants.TIFF_TAG_PAGE_NAME),
                new MetadataObject(0x011e, "XPosition", TiffTagConstants.TIFF_TAG_XPOSITION),
                new MetadataObject(0x011f, "YPosition", TiffTagConstants.TIFF_TAG_YPOSITION),
                new MetadataObject(0x0120, "FreeOffsets", TiffTagConstants.TIFF_TAG_FREE_OFFSETS),
                new MetadataObject(0x0121, "FreeByteCount", TiffTagConstants.TIFF_TAG_FREE_BYTE_COUNTS),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0122, "GrayResponseUnit", null),
                new MetadataObject(0x0123, "GrayResponseCurve", TiffTagConstants.TIFF_TAG_GRAY_RESPONSE_CURVE),
                new MetadataObject(0x0124, "T4Options", TiffTagConstants.TIFF_TAG_T4_OPTIONS),
                new MetadataObject(0x0125, "T6Options", TiffTagConstants.TIFF_TAG_T6_OPTIONS),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0128, "ResolutionUnit", null),
                new MetadataObject(0x0129, "PageNumber", TiffTagConstants.TIFF_TAG_PAGE_NUMBER),
                new MetadataObject(0x012c, "ColorResponseUnit", null),
                new MetadataObject(0x012d, "TransferFunction", TiffTagConstants.TIFF_TAG_TRANSFER_FUNCTION),
                new MetadataObject(0x0131, "Software", TiffTagConstants.TIFF_TAG_SOFTWARE),
                new MetadataObject(0x0132, "DateTime", TiffTagConstants.TIFF_TAG_DATE_TIME),
                new MetadataObject(0x013b, "Artist", TiffTagConstants.TIFF_TAG_ARTIST),
                new MetadataObject(0x013c, "HostComputer", TiffTagConstants.TIFF_TAG_HOST_COMPUTER),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x013d, "Predictor", null),
                new MetadataObject(0x013e, "WhitePoint", TiffTagConstants.TIFF_TAG_WHITE_POINT),
                new MetadataObject(0x013f, "PrimaryChromaticities", TiffTagConstants.TIFF_TAG_PRIMARY_CHROMATICITIES),
                new MetadataObject(0x0140, "ColorMap", null),
                new MetadataObject(0x0141, "HalftoneHints", TiffTagConstants.TIFF_TAG_HALFTONE_HINTS),
                new MetadataObject(0x0142, "TileWidth", TiffTagConstants.TIFF_TAG_TILE_WIDTH),
                new MetadataObject(0x0143, "TileLength", TiffTagConstants.TIFF_TAG_TILE_LENGTH),
                new MetadataObject(0x0144, "TileOffsets", TiffTagConstants.TIFF_TAG_TILE_OFFSETS),
                new MetadataObject(0x0145, "TileByteCounts", TiffTagConstants.TIFF_TAG_TILE_BYTE_COUNTS),
                new MetadataObject(0x0146, "BadFaxLines", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0147, "CleanFaxData", null),
                new MetadataObject(0x0148, "ConsecutiveBadFaxLines", null),
                // Add 0x014a SubIFD/A100DataOffset?
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x014c, "InkSet", TiffTagConstants.TIFF_TAG_INK_SET),
                new MetadataObject(0x014d, "InkNames", TiffTagConstants.TIFF_TAG_INK_NAMES),
                new MetadataObject(0x014e, "NumberOfInks", TiffTagConstants.TIFF_TAG_NUMBER_OF_INKS),
                new MetadataObject(0x0150, "DotRange", TiffTagConstants.TIFF_TAG_DOT_RANGE),
                new MetadataObject(0x0151, "TargetPrinter", TiffTagConstants.TIFF_TAG_TARGET_PRINTER),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0152, "ExtraSamples", TiffTagConstants.TIFF_TAG_EXTRA_SAMPLES),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0153, "SampleFormat", TiffTagConstants.TIFF_TAG_SAMPLE_FORMAT),
                new MetadataObject(0x0155, "SMaxSampleValue", TiffTagConstants.TIFF_TAG_SMAX_SAMPLE_VALUE),
                new MetadataObject(0x0156, "TransferRange", TiffTagConstants.TIFF_TAG_TRANSFER_RANGE),
                new MetadataObject(0x0157, "ClipPath", null),
                new MetadataObject(0x0158, "XClipPathUnits", null),
                new MetadataObject(0x0159, "YClipPathUnits", null),
                new MetadataObject(0x015a, "Indexed", null),
                new MetadataObject(0x015b, "JPEGTables", null),
                new MetadataObject(0x015f, "OPIProxy", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0190, "GlobalParametersIFD", null),
                new MetadataObject(0x0191, "ProfileType", null),
                new MetadataObject(0x0192, "FaxProfile", null),
                // My methods are for me to be ashamed about thank you very much
                new MetadataObject(0x0193, "CodingMethods", null),
                new MetadataObject(0x0194, "VersionYear", null),
                new MetadataObject(0x0195, "ModeNumber", null),
                new MetadataObject(0x01b1, "Decode", null),
                new MetadataObject(0x01b2, "DefaultImageColor", null),
                new MetadataObject(0x01b3, "T82Options", null),
                new MetadataObject(0x01b5, "JPEGTables", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0200, "JPEGProc", TiffTagConstants.TIFF_TAG_JPEG_PROC),
                new MetadataObject(0x0201, "ThumbnailOffset", TiffTagConstants.TIFF_TAG_JPEG_INTERCHANGE_FORMAT),
                new MetadataObject(0x0202, "ThumbnailLength", TiffTagConstants.TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH),
                new MetadataObject(0x0203, "JPEGRestartInterval", TiffTagConstants.TIFF_TAG_JPEG_RESTART_INTERVAL),
                new MetadataObject(0x0205, "JPEGLosslessPredictors",
                        TiffTagConstants.TIFF_TAG_JPEG_LOSSLESS_PREDICTORS),
                new MetadataObject(0x0206, "JPEGPointTransforms", TiffTagConstants.TIFF_TAG_JPEG_POINT_TRANSFORMS),
                new MetadataObject(0x0207, "JPEGQTables", TiffTagConstants.TIFF_TAG_JPEG_QTABLES),
                new MetadataObject(0x0208, "JPEGDCTables", TiffTagConstants.TIFF_TAG_JPEG_DCTABLES),
                new MetadataObject(0x0209, "JPEGACTables", TiffTagConstants.TIFF_TAG_JPEG_ACTABLES),
                new MetadataObject(0x0211, "YCbCrCoefficients", TiffTagConstants.TIFF_TAG_YCBCR_COEFFICIENTS),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0212, "YCbCrSubSampling", TiffTagConstants.TIFF_TAG_YCBCR_SUB_SAMPLING),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0213, "YCbCrPositioning", TiffTagConstants.TIFF_TAG_YCBCR_POSITIONING),
                new MetadataObject(0x0214, "ReferenceBlackWhite", TiffTagConstants.TIFF_TAG_REFERENCE_BLACK_WHITE),
                new MetadataObject(0x022f, "StripRowCounts", null),
                // TODO: How the hell am I gonna add XMP directory
                new MetadataObject(0x02bc, "ApplicationNotes", null),
                new MetadataObject(0x0303, "RenderingIntent", null),
                new MetadataObject(0x03e7, "USPTOMiscellaneous", null),
                new MetadataObject(0x1000, "RelatedImageFileFormat", null),
                new MetadataObject(0x1001, "RelatedImageWidth", null),
                new MetadataObject(0x1002, "RelatedImageHeight", null),
                new MetadataObject(0x4746, "Rating", null),
                new MetadataObject(0x4747, "XP_DIP_XML", null),
                // Microsoft Stitch tags
                new MetadataObject(0x4748, "StitchInfo", null),
                new MetadataObject(0x4749, "RatingPercent", null),
                new MetadataObject(0x5001, "ResolutionXUnit", null),
                new MetadataObject(0x5002, "ResolutionYUnit", null),
                new MetadataObject(0x5003, "ResolutionXLengthUnit", null),
                new MetadataObject(0x5004, "ResolutionYLengthUnit", null),
                new MetadataObject(0x5005, "PrintFlags", null),
                new MetadataObject(0x5006, "PrintFlagsVersion", null),
                new MetadataObject(0x5007, "PrintFlagsCrop", null),
                new MetadataObject(0x5008, "PrintFlagsBleedWidth", null),
                new MetadataObject(0x5009, "PrintFlagsBleedWidthScale", null),
                new MetadataObject(0x500a, "HalftoneLPI", null),
                new MetadataObject(0x500b, "HalftoneLPIUnit", null),
                new MetadataObject(0x500c, "HalftoneDegree", null),
                new MetadataObject(0x500d, "HalftoneShape", null),
                new MetadataObject(0x500e, "HalftoneMisc", null),
                new MetadataObject(0x500f, "HalftoneScreen", null),
                new MetadataObject(0x5010, "JPEGQuality", null),
                new MetadataObject(0x5011, "GridSize", null),
                new MetadataObject(0x5012, "ThumbnailFormat", null),
                new MetadataObject(0x5013, "ThumbnailWidth", null),
                new MetadataObject(0x5014, "ThumbnailHeight", null),
                new MetadataObject(0x5015, "ThumbnailColorDepth", null),
                new MetadataObject(0x5016, "ThumbnailPlanes", null),
                new MetadataObject(0x5017, "ThumbnailRawBytes", null),
                new MetadataObject(0x5018, "ThumbnailLength", null),
                new MetadataObject(0x5019, "ThumbnailCompressedSize", null),
                new MetadataObject(0x501a, "ColorTransferFunction", null),
                new MetadataObject(0x501b, "ThumbnailData", null),
                new MetadataObject(0x5020, "ThumbnailImageWidth", null),
                new MetadataObject(0x5021, "ThumbnailImageHeight", null),
                new MetadataObject(0x5022, "ThumbnailBitsPerSample", null),
                new MetadataObject(0x5023, "ThumbnailCompression", null),
                new MetadataObject(0x5024, "ThumbnailPhotometricInterp", null),
                new MetadataObject(0x5025, "ThumbnailDescription", null),
                new MetadataObject(0x5026, "ThumbnailEquipMake", null),
                new MetadataObject(0x5027, "ThumbnailEquipModel", null),
                new MetadataObject(0x5028, "ThumbnailStripOffsets", null),
                new MetadataObject(0x5029, "ThumbnailOrientation", null),
                new MetadataObject(0x502a, "ThumbnailSamplesPerPixel", null),
                new MetadataObject(0x502b, "ThumbnailRowsPerStrip", null),
                new MetadataObject(0x502c, "ThumbnailStripByteCounts", null),
                new MetadataObject(0x502d, "ThumbnailResolutionX", null),
                new MetadataObject(0x502e, "ThumbnailResolutionY", null),
                new MetadataObject(0x502f, "ThumbnailPlanarConfig", null),
                new MetadataObject(0x5030, "ThumbnailResolutionUnit", null),
                new MetadataObject(0x5031, "ThumbnailTransferFunction", null),
                new MetadataObject(0x5032, "ThumbnailSoftware", null),
                new MetadataObject(0x5033, "ThumbnailDateTime", null),
                new MetadataObject(0x5034, "ThumbnailArtist", null),
                new MetadataObject(0x5035, "ThumbnailWhitePoint", null),
                new MetadataObject(0x5036, "ThumbnailPrimaryChromaticities", null),
                new MetadataObject(0x5037, "ThumbnailYCbCrCoefficients", null),
                new MetadataObject(0x5038, "ThumbnailYCbCrSubSampling", null),
                new MetadataObject(0x5039, "ThumbnailYCbCrPositioning", null),
                new MetadataObject(0x503a, "ThumbnailRefBlackWhite", null),
                new MetadataObject(0x503b, "ThumbnailCopyright", null),
                new MetadataObject(0x5090, "LuminanceTable", null),
                new MetadataObject(0x5091, "ChrominanceTable", null),
                new MetadataObject(0x5100, "FrameDelay", null),
                new MetadataObject(0x5101, "LoopCount", null),
                new MetadataObject(0x5102, "GlobalPalette", null),
                new MetadataObject(0x5103, "IndexBackground", null),
                new MetadataObject(0x5104, "IndexTransparent", null),
                new MetadataObject(0x5110, "PixelUnits", null),
                new MetadataObject(0x5111, "PixelsPerUnitX", null),
                new MetadataObject(0x5112, "PixelsPerUnitY", null),
                new MetadataObject(0x5113, "PaletteHistogram", null),
                // End of Microsoft Stitch tags
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x7000, "SonyRawFileType", null),
                new MetadataObject(0x7010, "SonyToneCurve", null),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x7031, "VignettingCorrection", null),
                new MetadataObject(0x7032, "VignettingCorrParams", null),
                new MetadataObject(0x7034, "ChromaticAberrationCorrection", null),
                new MetadataObject(0x7035, "ChromaticAberrationCorrParams", null),
                new MetadataObject(0x7036, "DistortionCorrection", null),
                new MetadataObject(0x7037, "DistortionCorrParams", null),
                new MetadataObject(0x7038, "SonyRawImageSize", null),
                new MetadataObject(0x7310, "BlackLevel", null),
                new MetadataObject(0x7313, "WB_RGGBLevels", null),
                new MetadataObject(0x74c7, "SonyCropTopLeft", null), // heheh
                new MetadataObject(0x74c8, "SonyCropSize", null),
                new MetadataObject(0x800d, "ImageID", null),
                new MetadataObject(0x80a3, "WangTag1", null),
                new MetadataObject(0x80a4, "WangAnnotation", null),
                new MetadataObject(0x80a5, "WangTag2", null),
                new MetadataObject(0x80a6, "WangTag3", null),
                new MetadataObject(0x80b9, "ImageReferencePoints", null),
                new MetadataObject(0x80ba, "RegionXformTackPoint", null),
                new MetadataObject(0x80bb, "WarpQuadrilateral", null),
                new MetadataObject(0x80bc, "AffineTransformMat", null),
                new MetadataObject(0x80e3, "Matteing", null),
                new MetadataObject(0x80e4, "DataType", null),
                new MetadataObject(0x80e5, "ImageDepth", null),
                new MetadataObject(0x80e6, "TileDepth", null),
                new MetadataObject(0x8214, "ImageFullWidth", null),
                new MetadataObject(0x8215, "ImageFullHeight", null),
                new MetadataObject(0x8216, "TextureFormat", null),
                new MetadataObject(0x8217, "WrapModes", null),
                new MetadataObject(0x8218, "FovCot", null),
                new MetadataObject(0x8219, "MatrixWorldToScreen", null),
                new MetadataObject(0x821a, "MatrixWorldtToCamera", null),
                new MetadataObject(0x827d, "Model2", null),
                new MetadataObject(0x828d, "CFARepeatPatternDim", null),
                new MetadataObject(0x828e, "CFAPattern2", null),
                new MetadataObject(0x828f, "BatteryLevel", null),
                new MetadataObject(0x8298, "Copyright", TiffTagConstants.TIFF_TAG_COPYRIGHT),
                new MetadataObject(0x829a, "ExposureTime", null),
                new MetadataObject(0x829d, "FNumber", null),
                new MetadataObject(0x82a5, "MDFileTag", null),
                new MetadataObject(0x82a6, "MDScalePixel", null),
                new MetadataObject(0x82a7, "MDColorTable", null),
                new MetadataObject(0x82a8, "MDLabName", null),
                new MetadataObject(0x82a9, "MDSampleInfo", null),
                new MetadataObject(0x82aa, "MDPrepDate", null),
                new MetadataObject(0x82ab, "MDPrepTime", null),
                new MetadataObject(0x82ac, "MDFileUnits", null),
                new MetadataObject(0x830e, "PixelScale", null),
                new MetadataObject(0x8335, "AdventScale", null),
                new MetadataObject(0x8336, "AdventRevision", null),
                new MetadataObject(0x835c, "UIC1Tag", null),
                new MetadataObject(0x835d, "UIC2Tag", null),
                new MetadataObject(0x835e, "UIC3Tag", null),
                new MetadataObject(0x835f, "UIC4Tag", null),
                // new MetadataObject(0x83bb, "IPTC-NAA", null),
                new MetadataObject(0x847e, "IntergraphPacketData", null),
                new MetadataObject(0x847f, "IntergraphFlagRegisters", null),
                new MetadataObject(0x8480, "IntergraphMatrix", null),
        };
    }

    public MetadataObject[] GetGPSDirectory() {
        return new MetadataObject[] { new MetadataObject(1, "metadataTag", true) };
    }

    public MetadataObject[] GetIPTCDirectory() {
        return new MetadataObject[] { new MetadataObject(1, "metadataTag", true) };
    }

    public Object convertTextValue(int tagId, String textField) {
        // Could probably do with making this a singleton somewhere.
        MetadataObject[] tiffTagArray = GetExifDirectory();

        for (MetadataObject metadataObject : tiffTagArray) {
            if (tagId == metadataObject.getMetadataId()) {
                Object tagConstant = metadataObject.writeTag();

                if (tagConstant.getClass() == TagInfoLong.class) {
                    // Perhaps?
                    return Long.parseLong(textField);
                }

                break;
            }
        }
        return null;
    }
}
