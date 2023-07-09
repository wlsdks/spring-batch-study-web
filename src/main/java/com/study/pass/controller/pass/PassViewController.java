package com.study.pass.controller.pass;

import com.study.pass.service.pass.Pass;
import com.study.pass.service.pass.PassService;
import com.study.pass.service.user.User;
import com.study.pass.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 사용자가 보는 이용권 조회 페이지 컨트롤러
 */
@Controller
@RequestMapping(value = "/passes")
@RequiredArgsConstructor
public class PassViewController {

    private final UserService userService;
    private final PassService passService;

    @GetMapping
    public ModelAndView getPasses(@RequestParam("userId") String userId, ModelAndView modelAndView) {
        // passes, user
        final List<Pass> passes = passService.getPasses(userId);
        final User user = userService.getUser(userId);

        modelAndView.addObject("passes", passes);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("pass/index");

        return modelAndView;
    }

}
