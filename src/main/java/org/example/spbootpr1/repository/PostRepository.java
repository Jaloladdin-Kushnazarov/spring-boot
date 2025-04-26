package org.example.spbootpr1.repository;

import jakarta.transaction.Transactional;
import org.example.spbootpr1.entity.Post;
import org.example.spbootpr1.projection.classbased.PostDTO;
import org.example.spbootpr1.projection.interfacebased.PostProjection;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //    @Query (nativeQuery = true, value = "select p.* from post p where p.user_id = ?1")   //native query
    @Query("from Post p where p.userId = ?1")
    //jpql query
    List<Post> getAllPostsByUserId(Long userId);

    @Query("from Post")
    List<Post> getAllPostsWithSortedColumn(Sort sort);


    @Transactional
    @Modifying
    @Query("delete from Post p where p.userId = ?1")
    void deletePostByUserId(Long userId);

    @Query("from Post")   //interfacebased projection?
    List<PostProjection> findAllPostsByInterfaceProjection();

    @Query("SELECT new org.example.spbootpr1.projection.classbased.PostDTO(p.id, p.title) FROM Post p")   //classbased projection(DTO)
    List<PostDTO> findAllPostsByClassProjection();
}
