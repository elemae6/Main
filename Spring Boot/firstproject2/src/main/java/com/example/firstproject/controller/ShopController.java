package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.dto.ReviewForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Review;
import com.example.firstproject.entity.User;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.ReviewRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class ShopController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/shop")
    public String index(Model model) {
        List<Review> reviewEntityList = reviewRepository.findAll();
        model.addAttribute("reviewList", reviewEntityList);
        return "shop/index";
    }
    @GetMapping("/shop/shop-detail")
    public String shopDetail() {
        return "shop/shop-detail";
    }
    @GetMapping("/shop/shop-listing")
    public String shopListing() {
        return "shop/shop-listing";
    }
    @GetMapping("/shop/new")
    public String newReviewForm() {
        return "shop/new";
    }
    @PostMapping("/shop/create")
    public String createReview(ReviewForm form){
        Review review = form.toEntity();
        Review saved = reviewRepository.save(review);
        return "redirect:/shop/bulletin-board/" + saved.getId();
    }
    @GetMapping("/shop/bulletin-board")
    public String bulletinBoard(Model model) {
        List<Review> reviewEntityList = reviewRepository.findAll();
        model.addAttribute("reviewList", reviewEntityList);
        return "shop/bulletin-board";
    }

    @GetMapping("/shop/bulletin-board/{id}")
    public String show(@PathVariable Long id, Model model) {
        Review reviewEntity = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", reviewEntity);
        return "shop/show";
    }

    @GetMapping("/shop/bulletin-board/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Review reviewEntity = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", reviewEntity);
        return "shop/edit";
    }


    @PostMapping("/shop/update")
    public String update(ReviewForm form) {
        Review reviewEntity = form.toEntity();
        Review target = reviewRepository.findById(reviewEntity.getId()).orElse(null);
        if (target!= null) {
            reviewRepository.save(reviewEntity);
        }
        return "redirect:/shop/bulletin-board/" + reviewEntity.getId();
    }

    @GetMapping("/shop/bulletin-board/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Review target = reviewRepository.findById(id).orElse(null);
        if (target != null) {
            reviewRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제가 완료되었습니다!");
        }
        return "redirect:/shop/bulletin-board";
    }
}
