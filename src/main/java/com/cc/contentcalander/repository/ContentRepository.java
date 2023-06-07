package com.cc.contentcalander.repository;

import com.cc.contentcalander.model.Content;
import com.cc.contentcalander.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContaining(String keyword);

    @Query("""
            SELECT * FROM content WHERE status = :status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
