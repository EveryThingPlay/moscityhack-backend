package mch.subschool.backend.service;

import mch.subschool.backend.model.RawClientData;

import java.io.FileNotFoundException;
import java.util.List;

public interface CsvParserService {
    List<RawClientData> parseRawClientData(String path) throws FileNotFoundException;
}
