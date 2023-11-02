package com.fms.service.storage;

import com.fms.config.AppConfig;
import com.fms.model.StorageDTO;
import com.fms.repository.FileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;

import java.util.Collections;

public class FilePerYearDateStorageStrategyServiceTest {

    AppConfig appConfig = new AppConfig(Collections.emptyList(), "DUMMY_PATH", false);

    @Mock
    FileRepository fileRepository;

    FilePerYearDateStorageStrategyService filePerYearDateStorageStrategyService = new FilePerYearDateStorageStrategyService(appConfig, fileRepository);

    @Test
    public void should_run_storage(){
        StorageDTO storageDto = new StorageDTO();
        storageDto.setMultipartFile(ArgumentMatchers.any());
        storageDto.setTenant(ArgumentMatchers.anyString());
        storageDto.setContent(ArgumentMatchers.anyString().getBytes());

        filePerYearDateStorageStrategyService.store(storageDto);
    }
}
