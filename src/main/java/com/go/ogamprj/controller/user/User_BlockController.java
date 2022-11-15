package com.go.ogamprj.controller.user;

import com.go.ogamprj.dto.Block;
import com.go.ogamprj.dto.Board;
import com.go.ogamprj.sevice.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Controller
public class User_BlockController {
    @Autowired
    BlockService blockService;

    public static void init(HttpServletResponse response) {
        response.setContentType("text/html; charset=euc-kr");
        response.setCharacterEncoding("euc-kr");
    }

    @RequestMapping("/blockPage")
    public String blockPage(HttpServletRequest request, Model model) {
        String member_email = (String) request.getSession().getAttribute("loginUser");
//        String member_email = "user1@ogam.com";
        List<HashMap<String, Object>> blockList = blockService.blockList(member_email);
        model.addAttribute("blockList", blockList);
        model.addAttribute("blockCnt", blockList.size());

        return "user/noticePage/blockList";
    }

    @RequestMapping("/blockDel")
    public String blockDel(@RequestParam int block_seq) {
//        System.out.println(block_seq);

        blockService.blockDel(block_seq);
        return "redirect:/blockPage";
    }

    @RequestMapping("/blockPlus")
    public String blockPlus(HttpServletRequest request
                            , HttpServletResponse response
                            , @RequestParam String member_nick) throws IOException {

        String member_email = (String) request.getSession().getAttribute("loginUser");
//        String member_email = "user1@ogam.com";
//        System.out.println(member_email);
        init(response);
        PrintWriter out = response.getWriter();

        String block_email = blockService.findId(member_nick);

        if(blockService.doubleBlock(new Block(member_email, block_email)) == 1) {
            out.println("<script>alert('already blocked'); location.href='/blockPage'</script>");
            out.flush();
        } else {
            blockService.blockPlus(new Block(0, member_email, block_email));
        }

        return "redirect:/blockPage";
    }

}
