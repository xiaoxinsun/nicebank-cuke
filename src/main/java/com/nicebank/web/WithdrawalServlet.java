package com.nicebank.web;

import com.nicebank.Account;
import com.nicebank.AutomatedTeller;
import com.nicebank.CashSlot;
import com.nicebank.Teller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WithdrawalServlet extends HttpServlet {

    private final CashSlot cashSlot;
    private final Account account;
    private final Teller teller;

    public WithdrawalServlet(CashSlot cashSlot, Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
        teller = new AutomatedTeller(cashSlot);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int amount = Integer.parseInt(request.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
                "<html><head><title>Nice Bank ATM</title></head>" +
                        "<body>Please take your $" + cashSlot.contents() + "</body>" +
                        "</html>"
        );
    }

}
