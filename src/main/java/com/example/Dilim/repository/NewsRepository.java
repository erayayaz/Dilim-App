package com.example.Dilim.repository;

import com.example.Dilim.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "SELECT * FROM news n where n.title_tr = ?1 or n.title_eng = ?2", nativeQuery = true)
    News findByTitleTrAndTitleEng(String titleTr, String titleEng);

    @Query(value = "SELECT * FROM news n order by n.news_id", nativeQuery = true)
    List<News> findAll();

    @Query(value = "SELECT * FROM news n where n.created_date like ?1% or n.updated_date like ?1% order by n.news_id", nativeQuery = true)
    List<News> findByDate(String requestedDate);
}
