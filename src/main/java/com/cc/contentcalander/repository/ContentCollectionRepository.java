package com.cc.contentcalander.repository;

import com.cc.contentcalander.model.Content;
import com.cc.contentcalander.model.Status;
import com.cc.contentcalander.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> getContent() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(item -> item.id().equals(id)).findFirst();
    }

    public void create(Content content) {
        contentList.add(content);
    }

    public boolean existById(Integer id) {
        return contentList.stream().filter(item -> item.id().equals(id)).count() == 1;

    }

    public void update(Content content, Integer id) {
        contentList.removeIf(item -> item.id().equals(id));
        create(content);
    }

    public void delete(Integer id) {
        contentList.removeIf(item -> item.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "Title",
                "Description",
                Status.COMPLETED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );
        contentList.add(c);
    }
}
