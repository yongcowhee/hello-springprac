package Pracspring.hellospringprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
        public class HelloController {
            @GetMapping("hello")  // web 어플리케이션에서 /hello라고 들어오면 이 메소드를 호출해줌
            public String hello(Model model){
                // model은 MVC(Model, View, Controller) 에서의 model임
                model.addAttribute("data", "hello!!");
                // model.addAttribute에서 key로 넣은 data value는 hello!!임.
                return "hello";
            }

            @GetMapping("hello-mvc")
            public String helloMvc(@RequestParam("name") String name, Model model){
                model.addAttribute("name", name);
                return "hello-template";
            }

            @GetMapping("hello-string")
            @ResponseBody // http에서 헤더부와 바디부..가 있는데 .. 바디부에 이 데이터를 직접 넣어주겠다. json으로 반환하는 것이 기본값
            public String helloString(@RequestParam("name") String name){
                return "hello " + name; //만약 name이 spring이라면 hello spring으로 바뀔 것
            }

            @GetMapping("hello-api")
            @ResponseBody
            public Pracspring.hellospringprac.controller.HelloController.Hello helloApi(@RequestParam("name") String name){
                Pracspring.hellospringprac.controller.HelloController.Hello hello = new Pracspring.hellospringprac.controller.HelloController.Hello();
                hello.setName(name);
                return hello;
            }
            static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
