package com.example.video.VideoService;

import com.example.video.Repository.VideoRepository;
import com.example.video.entity.Video;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class VideoServiceImplTest {

    VideoRepository videoRepository = mock(VideoRepository.class);
    VideoService service = new VideoServiceImpl(videoRepository);

    String testName = "myVid";


    @Test
    void getVideo() throws VideoNotFoundException {
        Video expected = new Video(testName, null);
        when(videoRepository.findByName(testName))
                .thenReturn(expected);
        when(videoRepository.existsByName(testName))
                .thenReturn(true);
        Video actual = service.getVideo(testName);
        assertEquals(expected, actual);
        verify(videoRepository, times(1)).existsByName(testName);
        verify(videoRepository, times(1)).findByName(testName);
    }

    @Test
    void getAllVideoNames() {
        List<String> expected = List.of("myVid", "otherVid");
        when(videoRepository.getAllEntryNames())
                .thenReturn(expected);
        List<String> actual = service.getAllVideoNames();
        assertEquals(expected, actual);
        verify(videoRepository, times(1)).getAllEntryNames();
    }

    @Test
    void saveVideo() throws IOException {
        MultipartFile file = mock(MultipartFile.class);
        Video testVid = new Video(testName, file.getBytes());
        service.saveVideo(file, testName);
        verify(videoRepository, times(1)).existsByName(testName);
        verify(videoRepository, times(1)).save(testVid);
    }
}