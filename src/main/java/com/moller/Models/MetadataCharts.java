package com.moller.Models;

import java.util.HashMap;

public class MetadataCharts {

    // #region Directories
    public static MetadataObject[] GetExifDirectory() {
        // TODO: Fix these entries.

        return new MetadataObject[] {
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0001, "InteropIndex", "String", 3),
                new MetadataObject(0x0002, "InteropVersion", "Undefined", 0),
                new MetadataObject(0x000b, "ProcessingSoftware", "String", 0),
                new MetadataObject(0x00fe, "NewSubfileType", "Long", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x00ff, "OldSubfileType", "Short", 1),
                new MetadataObject(0x0100, "ImageWidth", "ShortOrLong", 0),
                new MetadataObject(0x0101, "ImageHeight", "ShortOrLong", 0),
                new MetadataObject(0x0102, "BitsPerSample", "Shorts", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0103, "Compression", "Short", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0106, "PhotometicInterpretation", "Short", 5),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0107, "Thresholding", "Short", 1),
                new MetadataObject(0x0108, "CellWidth", "Short", 0),
                new MetadataObject(0x0109, "CellLength", "Short", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x010a, "FillOrder", "Short", 1),
                new MetadataObject(0x010d, "DocumentName", "String", 0),
                new MetadataObject(0x010e, "ImageDescription", "String", 0),
                new MetadataObject(0x010f, "Make", "String", 0), new MetadataObject(0x0110,
                        "Model", "String", 0),
                new MetadataObject(0x0111, "StripOffsets", "ShortOrLong", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0112, "Orientation", "Short", 1),
                new MetadataObject(0x0115, "SamplesPerPixel", "Short", 0),
                new MetadataObject(0x0116, "RowsPerStrip", "ShortOrLong", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0117, "StripByteCounts", "ShortOrLong", 0),
                new MetadataObject(0x0118, "MinSampleValue", "Shorts", 0),
                new MetadataObject(0x0119, "MaxSampleValue", "Shorts", 0),
                new MetadataObject(0x011a, "XResolution", "Rational", 0),
                new MetadataObject(0x011b, "YResolution", "Rational", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x011c, "PlanarConfiguration", "Short", 1),
                new MetadataObject(0x011d, "PageName", "String", 0),
                new MetadataObject(0x011e, "XPosition", "Rational", 0),
                new MetadataObject(0x011f, "YPosition", "Rational", 0),
                new MetadataObject(0x0120, "FreeOffsets", "Longs", 0),
                new MetadataObject(0x0121, "FreeByteCount", "Longs", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0122, "GrayResponseUnit", "Short", 1),
                new MetadataObject(0x0123, "GrayResponseCurve", "Shorts", 0),
                new MetadataObject(0x0124, "T4Options", "Long", 0), new MetadataObject(0x0125, "T6Options", "Long", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0128, "ResolutionUnit", "Short", 1),
                new MetadataObject(0x0129, "PageNumber", "Shorts", 2),
                new MetadataObject(0x012c, "ColorResponseUnit", "String", 0),
                new MetadataObject(0x012d, "TransferFunction", "Shorts", 0),
                new MetadataObject(0x0131, "Software", "String", 0),
                new MetadataObject(0x0132, "DateTime", "String", 0), new MetadataObject(0x013b, "Artist", "String", 0),
                new MetadataObject(0x013c, "HostComputer", "String", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x013d, "Predictor", "Short", 5),
                new MetadataObject(0x013e, "WhitePoint", "Rationals", 0),
                new MetadataObject(0x013f, "PrimaryChromaticities", "Rationals", 0),
                new MetadataObject(0x0140, "ColorMap", "String", 0),
                new MetadataObject(0x0141, "HalftoneHints", "Shorts", 0),
                new MetadataObject(0x0142, "TileWidth", "ShortOrLong", 0),
                new MetadataObject(0x0143, "TileLength", "ShortOrLong", 0),
                new MetadataObject(0x0144, "TileOffsets", "Longs", 0),
                new MetadataObject(0x0145, "TileByteCounts", "ShortOrLong", 0),
                new MetadataObject(0x0146, "BadFaxLines", "Short", 0),
                // TODO: How do I add this? List for dropdown?
                new MetadataObject(0x0147, "CleanFaxData", "Short", 1),
                /*
                 * new MetadataObject(0x0148, "ConsecutiveBadFaxLines", null),
                 * // Add 0x014a SubIFD/A100DataOffset?
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x014c, "InkSet", TiffTagConstants.TIFF_TAG_INK_SET),
                 * new MetadataObject(0x014d, "InkNames", TiffTagConstants.TIFF_TAG_INK_NAMES),
                 * new MetadataObject(0x014e, "NumberOfInks",
                 * TiffTagConstants.TIFF_TAG_NUMBER_OF_INKS),
                 * new MetadataObject(0x0150, "DotRange", TiffTagConstants.TIFF_TAG_DOT_RANGE),
                 * new MetadataObject(0x0151, "TargetPrinter",
                 * TiffTagConstants.TIFF_TAG_TARGET_PRINTER),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0152, "ExtraSamples",
                 * TiffTagConstants.TIFF_TAG_EXTRA_SAMPLES),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0153, "SampleFormat",
                 * TiffTagConstants.TIFF_TAG_SAMPLE_FORMAT),
                 * new MetadataObject(0x0155, "SMaxSampleValue",
                 * TiffTagConstants.TIFF_TAG_SMAX_SAMPLE_VALUE),
                 * new MetadataObject(0x0156, "TransferRange",
                 * TiffTagConstants.TIFF_TAG_TRANSFER_RANGE),
                 * new MetadataObject(0x0157, "ClipPath", null), new MetadataObject(0x0158,
                 * "XClipPathUnits", null),
                 * new MetadataObject(0x0159, "YClipPathUnits", null), new
                 * MetadataObject(0x015a, "Indexed", null),
                 * new MetadataObject(0x015b, "JPEGTables", null), new MetadataObject(0x015f,
                 * "OPIProxy", null),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0190, "GlobalParametersIFD", null),
                 * new MetadataObject(0x0191, "ProfileType", null), new MetadataObject(0x0192,
                 * "FaxProfile", null),
                 * // My methods are for me to be ashamed about thank you very much
                 * new MetadataObject(0x0193, "CodingMethods", null), new MetadataObject(0x0194,
                 * "VersionYear", null),
                 * new MetadataObject(0x0195, "ModeNumber", null), new MetadataObject(0x01b1,
                 * "Decode", null),
                 * new MetadataObject(0x01b2, "DefaultImageColor", null), new
                 * MetadataObject(0x01b3, "T82Options", null),
                 * new MetadataObject(0x01b5, "JPEGTables", null),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0200, "JPEGProc", TiffTagConstants.TIFF_TAG_JPEG_PROC),
                 * new MetadataObject(0x0201, "ThumbnailOffset",
                 * TiffTagConstants.TIFF_TAG_JPEG_INTERCHANGE_FORMAT),
                 * new MetadataObject(0x0202, "ThumbnailLength",
                 * TiffTagConstants.TIFF_TAG_JPEG_INTERCHANGE_FORMAT_LENGTH),
                 * new MetadataObject(0x0203, "JPEGRestartInterval",
                 * TiffTagConstants.TIFF_TAG_JPEG_RESTART_INTERVAL),
                 * new MetadataObject(0x0205, "JPEGLosslessPredictors",
                 * TiffTagConstants.TIFF_TAG_JPEG_LOSSLESS_PREDICTORS),
                 * new MetadataObject(0x0206, "JPEGPointTransforms",
                 * TiffTagConstants.TIFF_TAG_JPEG_POINT_TRANSFORMS),
                 * new MetadataObject(0x0207, "JPEGQTables",
                 * TiffTagConstants.TIFF_TAG_JPEG_QTABLES),
                 * new MetadataObject(0x0208, "JPEGDCTables",
                 * TiffTagConstants.TIFF_TAG_JPEG_DCTABLES),
                 * new MetadataObject(0x0209, "JPEGACTables",
                 * TiffTagConstants.TIFF_TAG_JPEG_ACTABLES),
                 * new MetadataObject(0x0211, "YCbCrCoefficients",
                 * TiffTagConstants.TIFF_TAG_YCBCR_COEFFICIENTS),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0212, "YCbCrSubSampling",
                 * TiffTagConstants.TIFF_TAG_YCBCR_SUB_SAMPLING),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x0213, "YCbCrPositioning",
                 * TiffTagConstants.TIFF_TAG_YCBCR_POSITIONING),
                 * new MetadataObject(0x0214, "ReferenceBlackWhite",
                 * TiffTagConstants.TIFF_TAG_REFERENCE_BLACK_WHITE),
                 * new MetadataObject(0x022f, "StripRowCounts", null),
                 * // TODO: How the hell am I gonna add XMP directory
                 * new MetadataObject(0x02bc, "ApplicationNotes", null),
                 * new MetadataObject(0x0303, "RenderingIntent", null),
                 * new MetadataObject(0x03e7, "USPTOMiscellaneous", null),
                 * new MetadataObject(0x1000, "RelatedImageFileFormat", null),
                 * new MetadataObject(0x1001, "RelatedImageWidth", null),
                 * new MetadataObject(0x1002, "RelatedImageHeight", null), new
                 * MetadataObject(0x4746, "Rating", null),
                 * new MetadataObject(0x4747, "XP_DIP_XML", null),
                 * // Microsoft Stitch tags
                 * new MetadataObject(0x4748, "StitchInfo", null), new MetadataObject(0x4749,
                 * "RatingPercent", null),
                 * new MetadataObject(0x5001, "ResolutionXUnit", null),
                 * new MetadataObject(0x5002, "ResolutionYUnit", null),
                 * new MetadataObject(0x5003, "ResolutionXLengthUnit", null),
                 * new MetadataObject(0x5004, "ResolutionYLengthUnit", null),
                 * new MetadataObject(0x5005, "PrintFlags", null), new MetadataObject(0x5006,
                 * "PrintFlagsVersion", null),
                 * new MetadataObject(0x5007, "PrintFlagsCrop", null),
                 * new MetadataObject(0x5008, "PrintFlagsBleedWidth", null),
                 * new MetadataObject(0x5009, "PrintFlagsBleedWidthScale", null),
                 * new MetadataObject(0x500a, "HalftoneLPI", null), new MetadataObject(0x500b,
                 * "HalftoneLPIUnit", null),
                 * new MetadataObject(0x500c, "HalftoneDegree", null), new
                 * MetadataObject(0x500d, "HalftoneShape", null),
                 * new MetadataObject(0x500e, "HalftoneMisc", null), new MetadataObject(0x500f,
                 * "HalftoneScreen", null),
                 * new MetadataObject(0x5010, "JPEGQuality", null), new MetadataObject(0x5011,
                 * "GridSize", null),
                 * new MetadataObject(0x5012, "ThumbnailFormat", null), new
                 * MetadataObject(0x5013, "ThumbnailWidth", null),
                 * new MetadataObject(0x5014, "ThumbnailHeight", null),
                 * new MetadataObject(0x5015, "ThumbnailColorDepth", null),
                 * new MetadataObject(0x5016, "ThumbnailPlanes", null),
                 * new MetadataObject(0x5017, "ThumbnailRawBytes", null),
                 * new MetadataObject(0x5018, "ThumbnailLength", null),
                 * new MetadataObject(0x5019, "ThumbnailCompressedSize", null),
                 * new MetadataObject(0x501a, "ColorTransferFunction", null),
                 * new MetadataObject(0x501b, "ThumbnailData", null),
                 * new MetadataObject(0x5020, "ThumbnailImageWidth", null),
                 * new MetadataObject(0x5021, "ThumbnailImageHeight", null),
                 * new MetadataObject(0x5022, "ThumbnailBitsPerSample", null),
                 * new MetadataObject(0x5023, "ThumbnailCompression", null),
                 * new MetadataObject(0x5024, "ThumbnailPhotometricInterp", null),
                 * new MetadataObject(0x5025, "ThumbnailDescription", null),
                 * new MetadataObject(0x5026, "ThumbnailEquipMake", null),
                 * new MetadataObject(0x5027, "ThumbnailEquipModel", null),
                 * new MetadataObject(0x5028, "ThumbnailStripOffsets", null),
                 * new MetadataObject(0x5029, "ThumbnailOrientation", null),
                 * new MetadataObject(0x502a, "ThumbnailSamplesPerPixel", null),
                 * new MetadataObject(0x502b, "ThumbnailRowsPerStrip", null),
                 * new MetadataObject(0x502c, "ThumbnailStripByteCounts", null),
                 * new MetadataObject(0x502d, "ThumbnailResolutionX", null),
                 * new MetadataObject(0x502e, "ThumbnailResolutionY", null),
                 * new MetadataObject(0x502f, "ThumbnailPlanarConfig", null),
                 * new MetadataObject(0x5030, "ThumbnailResolutionUnit", null),
                 * new MetadataObject(0x5031, "ThumbnailTransferFunction", null),
                 * new MetadataObject(0x5032, "ThumbnailSoftware", null),
                 * new MetadataObject(0x5033, "ThumbnailDateTime", null),
                 * new MetadataObject(0x5034, "ThumbnailArtist", null),
                 * new MetadataObject(0x5035, "ThumbnailWhitePoint", null),
                 * new MetadataObject(0x5036, "ThumbnailPrimaryChromaticities", null),
                 * new MetadataObject(0x5037, "ThumbnailYCbCrCoefficients", null),
                 * new MetadataObject(0x5038, "ThumbnailYCbCrSubSampling", null),
                 * new MetadataObject(0x5039, "ThumbnailYCbCrPositioning", null),
                 * new MetadataObject(0x503a, "ThumbnailRefBlackWhite", null),
                 * new MetadataObject(0x503b, "ThumbnailCopyright", null),
                 * new MetadataObject(0x5090, "LuminanceTable", null),
                 * new MetadataObject(0x5091, "ChrominanceTable", null), new
                 * MetadataObject(0x5100, "FrameDelay", null),
                 * new MetadataObject(0x5101, "LoopCount", null), new MetadataObject(0x5102,
                 * "GlobalPalette", null),
                 * new MetadataObject(0x5103, "IndexBackground", null),
                 * new MetadataObject(0x5104, "IndexTransparent", null), new
                 * MetadataObject(0x5110, "PixelUnits", null),
                 * new MetadataObject(0x5111, "PixelsPerUnitX", null), new
                 * MetadataObject(0x5112, "PixelsPerUnitY", null),
                 * new MetadataObject(0x5113, "PaletteHistogram", null),
                 * // End of Microsoft Stitch tags
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x7000, "SonyRawFileType", null), new
                 * MetadataObject(0x7010, "SonyToneCurve", null),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x7031, "VignettingCorrection", null),
                 * new MetadataObject(0x7032, "VignettingCorrParams", null),
                 * new MetadataObject(0x7034, "ChromaticAberrationCorrection", null),
                 * new MetadataObject(0x7035, "ChromaticAberrationCorrParams", null),
                 * new MetadataObject(0x7036, "DistortionCorrection", null),
                 * new MetadataObject(0x7037, "DistortionCorrParams", null),
                 * new MetadataObject(0x7038, "SonyRawImageSize", null), new
                 * MetadataObject(0x7310, "BlackLevel", null),
                 * new MetadataObject(0x7313, "WB_RGGBLevels", null), new MetadataObject(0x74c7,
                 * "SonyCropTopLeft", null), // heheh
                 * new MetadataObject(0x74c8, "SonyCropSize", null), new MetadataObject(0x800d,
                 * "ImageID", null),
                 * new MetadataObject(0x80a3, "WangTag1", null), new MetadataObject(0x80a4,
                 * "WangAnnotation", null),
                 * new MetadataObject(0x80a5, "WangTag2", null), new MetadataObject(0x80a6,
                 * "WangTag3", null),
                 * new MetadataObject(0x80b9, "ImageReferencePoints", null),
                 * new MetadataObject(0x80ba, "RegionXformTackPoint", null),
                 * new MetadataObject(0x80bb, "WarpQuadrilateral", null),
                 * new MetadataObject(0x80bc, "AffineTransformMat", null), new
                 * MetadataObject(0x80e3, "Matteing", null),
                 * new MetadataObject(0x80e4, "DataType", null), new MetadataObject(0x80e5,
                 * "ImageDepth", null),
                 * new MetadataObject(0x80e6, "TileDepth", null), new MetadataObject(0x8214,
                 * "ImageFullWidth", null),
                 * new MetadataObject(0x8215, "ImageFullHeight", null), new
                 * MetadataObject(0x8216, "TextureFormat", null),
                 * new MetadataObject(0x8217, "WrapModes", null), new MetadataObject(0x8218,
                 * "FovCot", null),
                 * new MetadataObject(0x8219, "MatrixWorldToScreen", null),
                 * new MetadataObject(0x821a, "MatrixWorldtToCamera", null), new
                 * MetadataObject(0x827d, "Model2", null),
                 * new MetadataObject(0x828d, "CFARepeatPatternDim", null),
                 * new MetadataObject(0x828e, "CFAPattern2", null), new MetadataObject(0x828f,
                 * "BatteryLevel", null),
                 * new MetadataObject(0x8298, "Copyright", TiffTagConstants.TIFF_TAG_COPYRIGHT),
                 * new MetadataObject(0x829a, "ExposureTime", null), new MetadataObject(0x829d,
                 * "FNumber", null),
                 * new MetadataObject(0x82a5, "MDFileTag", null), new MetadataObject(0x82a6,
                 * "MDScalePixel", null),
                 * new MetadataObject(0x82a7, "MDColorTable", null), new MetadataObject(0x82a8,
                 * "MDLabName", null),
                 * new MetadataObject(0x82a9, "MDSampleInfo", null), new MetadataObject(0x82aa,
                 * "MDPrepDate", null),
                 * new MetadataObject(0x82ab, "MDPrepTime", null), new MetadataObject(0x82ac,
                 * "MDFileUnits", null),
                 * new MetadataObject(0x830e, "PixelScale", null), new MetadataObject(0x8335,
                 * "AdventScale", null),
                 * new MetadataObject(0x8336, "AdventRevision", null), new
                 * MetadataObject(0x835c, "UIC1Tag", null),
                 * new MetadataObject(0x835d, "UIC2Tag", null), new MetadataObject(0x835e,
                 * "UIC3Tag", null),
                 * new MetadataObject(0x835f, "UIC4Tag", null),
                 * // new MetadataObject(0x83bb, "IPTC-NAA", null),
                 * new MetadataObject(0x847e, "IntergraphPacketData", null),
                 * new MetadataObject(0x847f, "IntergraphFlagRegisters", null),
                 * new MetadataObject(0x8480, "IntergraphMatrix", null), new
                 * MetadataObject(0x8481, "INGRReserved", null),
                 * new MetadataObject(0x8482, "ModelTiePoint", null), new MetadataObject(0x84e0,
                 * "Site", null),
                 * new MetadataObject(0x84e1, "ColorSequence", null), new MetadataObject(0x84e2,
                 * "IT8Header", null),
                 * new MetadataObject(0x84e3, "RasterPadding", null), new MetadataObject(0x84e4,
                 * "BitsPerRunLength", null),
                 * new MetadataObject(0x84e5, "BitsPerExtendedRunLength", null),
                 * new MetadataObject(0x84e6, "ColorTable", null), new MetadataObject(0x84e7,
                 * "ImageColorIndicator", null),
                 * new MetadataObject(0x84e8, "BackgroundColorIndicator", null),
                 * new MetadataObject(0x84e9, "ImageColorValue", null),
                 * new MetadataObject(0x84ea, "BackgroundColorValue", null),
                 * new MetadataObject(0x84eb, "PixelIntensityRange", null),
                 * new MetadataObject(0x84ec, "TransparencyIndicator", null),
                 * new MetadataObject(0x84ed, "ColorCharacterization", null), new
                 * MetadataObject(0x84ee, "HCUsage", null),
                 * new MetadataObject(0x84ef, "TrapIndicator", null), // heheh
                 * new MetadataObject(0x84f0, "CMYKEquivalent", null), new
                 * MetadataObject(0x8546, "SEMInfo", null),
                 * // new MetadataObject(0x8568, "AFCP_IPTC", null), //It's its own directory
                 * new MetadataObject(0x85b8, "PixelMagicJBIGOptions", null),
                 * new MetadataObject(0x85d7, "JPLCartoIFD", null), new MetadataObject(0x85d8,
                 * "ModelTransform", null),
                 * new MetadataObject(0x8602, "WB_GRGBLevels", null),
                 * // new MetadataObject(0x8606, "LeafData", null), //It's its own directory
                 * // new MetadataObject(0x8649, "PhotoshopSettings", null), //It's its own
                 * // directory
                 * // new MetadataObject(0x8769, "ExifOffset", null), //It's its own directory
                 * // new MetadataObject(0x8773, "ICC_Profile", null), //It's its own directory
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x877f, "TIFF_FXExtensions", null),
                 * // TODO: How do I add this? List for dropdown?
                 * new MetadataObject(0x8780, "MultiProfiles", null), new MetadataObject(0x8781,
                 * "SharedData", null),
                 * new MetadataObject(0x8782, "T88Options", null), new MetadataObject(0x87ac,
                 * "ImageLayer", null),
                 * // new MetadataObject(0x87af, "GeoTiffDirectory", null), //I guess it's its
                 * own
                 * // directory?
                 * new MetadataObject(0x87b0, "GeoTiffDoubleParams", null),
                 * new MetadataObject(0x87b1, "GeoTiffAsciiParams", null), new
                 * MetadataObject(0x87be, "JBIGOptions", null),
                 * new MetadataObject(0x8822, "ExposureProgram", null),
                 * // TODO: Add the rest of the tags. And create own tag writables at some
                 * point.
                 */
        };
    }

    public static MetadataObject[] GetGPSDirectory() {
        return new MetadataObject[] {
                new MetadataObject(0x0000, "GPSVersionID", "Bytes", 0),
                new MetadataObject(0x0001, "GPSLatitudeRef", "String", 2),
                new MetadataObject(0x0002, "GPSLatitude", "Rationals", 3),
                new MetadataObject(0x0003, "GPSLongitudeRef", "String", 2),
                new MetadataObject(0x0004, "GPSLongitude", "Rationals", 3),
                new MetadataObject(0x0005, "GPSAltitudeRef", "Byte", 0),
                new MetadataObject(0x0006, "GPSAltitude", "Rational", 0),
                new MetadataObject(0x0007, "GPSTimeStamp", "Rationals", 3),
                new MetadataObject(0x0008, "GPSSatellites", "String", 0),
                new MetadataObject(0x0009, "GPSStatus", "String", 2),
                new MetadataObject(0x000a, "GPSMeasureMode", "String", 2),
                new MetadataObject(0x000b, "GPSDOP", "Rational", 1),
                new MetadataObject(0x000c, "GPSSpeedRef", "String", 2),
                new MetadataObject(0x000d, "GPSSpeed", "Rational", 1),
                new MetadataObject(0x000e, "GPSTrackRef", "String", 2),
                new MetadataObject(0x000f, "GPSTrack", "Rational", 1),
                new MetadataObject(0x0010, "GPSImgDirectionRef", "String", 2),
                new MetadataObject(0x0011, "GPSImgDirection", "Rational", 1),
                new MetadataObject(0x0012, "GPSMapDatum", "String", 0),
                new MetadataObject(0x0013, "GPSDestLatitudeRef", "String", 2),
                new MetadataObject(0x0014, "GPSDestLatitude", "Rationals", 3),
                new MetadataObject(0x0015, "GPSDestLongitudeRef", "String", 2),
                new MetadataObject(0x0016, "GPSDestLongitude", "Rationals", 3),
                new MetadataObject(0x0017, "GPSDestBearingRef", "String", 2),
                new MetadataObject(0x0018, "GPSDestBearing", "Rational", 1),
                new MetadataObject(0x0019, "GPSDestDistanceRef", "String", 2),
                new MetadataObject(0x001a, "GPSDestDistance", "Rational", 1),
                new MetadataObject(0x001b, "GPSProcessingMethod", "Undef", 0),
                new MetadataObject(0x001c, "GPSAreaInformation", "Undef", 0),
                new MetadataObject(0x001d, "GPSDateStamp", "String", 11),
                new MetadataObject(0x001e, "GPSDifferential", "Short", 1),
                new MetadataObject(0x001f, "GPSHPositioningError", "Rational", 1)
        };
    }

    public MetadataObject[] GetIPTCDirectory() {
        return new MetadataObject[] { new MetadataObject(1, "metadataTag", "Type", 0) };
    }
    // #endregion

    // #region Selection options by Directory
    public HashMap<String, String> GPSOptionSelectionMap(Integer tag) {
        HashMap<String, String> hmretval = new HashMap<>();

        switch (tag) {
            case 0x0001:
                hmretval.put("N", "North");
                hmretval.put("S", "South");
                break;
            case 0x0003:
                hmretval.put("E", "East");
                hmretval.put("W", "West");
            case 0x0005:
                hmretval.put("0", "Above Sea Level");
                hmretval.put("1", "Below Sea Level");
            case 0x0009:
                hmretval.put("A", "Measurement Active");
                hmretval.put("V", "Measurement Void");
            case 0x000a:
                hmretval.put("2", "2-Dimensional Measurement");
                hmretval.put("3", "3-Dimensional Measurement");
            case 0x000c:
                hmretval.put("K", "Kilometres Per Hour (km/h)");
                hmretval.put("M", "Miles Per Hour (mph)");
                hmretval.put("N", "Knots");
            case 0x000e:
                hmretval.put("M", "Magnetic North");
                hmretval.put("T", "True North");
            case 0x0010:
                hmretval.put("M", "Magnetic North");
                hmretval.put("T", "True North");
            case 0x0013:
                hmretval.put("N", "North");
                hmretval.put("S", "South");
            case 0x0015:
                hmretval.put("E", "East");
                hmretval.put("W", "West");
            case 0x0017:
                hmretval.put("M", "Magnetic North");
                hmretval.put("T", "True North");
            case 0x0019:
                hmretval.put("K", "Kilometres Per Hour (km/h)");
                hmretval.put("M", "Miles Per Hour (mph)");
                hmretval.put("N", "Knots");
            case 0x001b:
                hmretval.put("GPS", "GPS");
                hmretval.put("CELLID", "CELLID");
                hmretval.put("WLAN", "WLAN");
                hmretval.put("MANUAL", "MANUAL");
            case 0x001e:
                hmretval.put("0", "No Correction");
                hmretval.put("1", "Differential Corrected");
            default:
                break;
        }
        return hmretval;
    }

    public HashMap<String, String> RootOptionSelectionMap(Integer tag) {
        HashMap<String, String> hmretval = new HashMap<>();

        switch (tag) {
            case 0x0001:
                hmretval.put("R03", "DCF Option File");
                hmretval.put("R98", "DCF Basic File");
                hmretval.put("THM", "DCF Thumbnail File");
                break;
            case 0x00fe:
                // hmretval.put(null, null);
                break;
            default:
                break;
        }
        return hmretval;
    }
    // #endregion
}
