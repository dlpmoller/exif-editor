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
                // Microsoft Stitch directory
                new MetadataObject(0x4748, "StitchInfo", null),
                new MetadataObject(0x4749, "RatingPercent", null),
                new MetadataObject(0x5001, "ResolutionXUnit", null),
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
