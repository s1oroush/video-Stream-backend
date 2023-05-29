package com.example.video.VideoService;

import com.example.video.Exeptions.VideoAlreadyExistsException;
import com.example.video.Repository.VideoRepository;
import com.example.video.Video;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {
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
}
