package org.seal.startsaber.sealstarsaberdemo.controller;

import org.seal.starsaber.arch.http.ResponseOkEntity;
import org.seal.starsaber.arch.security.AttributePrincipalUser;
import org.seal.starsaber.arch.security.MethodPrincipalUser;
import org.seal.startsaber.sealstarsaberdemo.base.controller.BaseController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@RestController
@RequestMapping("/springsecurity")
public class SecurityController extends BaseController {

    @GetMapping("/username")
    public String userName(Principal principal){
        String name = principal.getName();
        return name;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/preSecurity")
    public ResponseOkEntity<String> preSecurity(){

        return ok("pre");
    }

    @PreAuthorize("hasPermission(#name,'has_per')")
    @GetMapping("/hasPermission")
    public ResponseOkEntity<String> hasPermission(){

        return ok("hasPermission");
    }

    @GetMapping("/methodPrincipalUser")
    public ResponseOkEntity<String> methodPrincipalUser(MethodPrincipalUser user){

        return ok(user.getName());
    }

    @GetMapping("/attributePrincipalUser")
    public ResponseOkEntity<AttributePrincipalUser> attributePrincipalUser(AttributePrincipalUser user){

        return ok(user);
    }
}
