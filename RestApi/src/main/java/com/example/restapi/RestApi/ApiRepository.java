    package com.example.restapi.RestApi;
    import org.springframework.data.jpa.repository.JpaRepository;
    import java.util.List;

    public interface ApiRepository extends JpaRepository<Book, Long> {
        List<Book> findByTitle(String title);
    }