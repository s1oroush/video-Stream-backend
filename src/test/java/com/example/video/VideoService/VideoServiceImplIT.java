package com.example.video.VideoService;

import com.example.video.Repository.VideoRepository;
import com.example.video.Video;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@SpringBootTest
@Transactional
public class VideoServiceImplIT {
    @Autowired
    VideoService service;

    @Autowired
    VideoRepository videoRepository;

    String testName = "myVid";

    @Test
    void getVideo() throws VideoNotFoundException {
        Video expected = new Video(testName, null);
        videoRepository.save(expected);
        Video actual = service.getVideo(testName);
        assertEquals(expected, actual);
    }


    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        service.saveVideo(file, testName);
        assertTrue(videoRepository.existsByName(testName));
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of(testName);
        videoRepository.save(new Video(testName, null));
        List<String> actual = service.getAllVideoNames();
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}

