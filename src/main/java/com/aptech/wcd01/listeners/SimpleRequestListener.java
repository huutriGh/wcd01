package com.aptech.wcd01.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;


@WebListener
public class SimpleRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application called from %s", sre.getServletRequest().getRemoteHost()));
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        sre.getServletContext().log(String.format("Application call end from %s", sre.getServletRequest().getRemoteHost()));

    }
}
