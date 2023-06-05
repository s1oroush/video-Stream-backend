package com.example.video.VideoService;

import com.example.video.Exeptions.VideoAlreadyExistsException;
import com.example.video.Repository.VideoRepository;
import com.example.video.entity.Video;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl  implements VideoService , CommandLineRunner {
    private VideoRepository videoRepository;

    @Override
    public Video getVideo(String name) throws VideoNotFoundException {
        if(!videoRepository.existsByName(name)){
            throw new VideoNotFoundException();
        }
        return videoRepository.findByName(name);
    }

    @Override
    public List<String> getAllVideoNames() {
        return videoRepository.getAllEntryNames();
    }

    @Override
    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(videoRepository.existsByName(name)){
            throw new VideoAlreadyExistsException();
        }
        Video newVid = new Video(name, file.getBytes());
        videoRepository.save(newVid);
    }

    @Override
    public void run(String... args) throws Exception {
        ClassPathResource resource = new ClassPathResource("movie/sample.mp4");
        File file = resource.getFile();
        Video video = new Video("sample",Files.readAllBytes(file.toPath()));
        videoRepository.save(video);
    }
}
