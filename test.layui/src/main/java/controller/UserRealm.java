package controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import model.C_operator;
import model.User;
import service.C_operator_Service;
import service.User_Service;

public class UserRealm extends AuthorizingRealm {
	
//	@Autowired
//	User_Service service;
	@Autowired
	C_operator_Service service;
	
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());  
    
    // �����������Ȩ�޸�ֵ
    @Override
    protected AuthorizationInfo  doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        UsernamePasswordToken token =  (UsernamePasswordToken)  SecurityUtils.getSubject().getPrincipal();
        String username = token.getUsername();
        logger.info(username + "��Ȩ...");
        // �����ݿ��в��Ҹ��û��Ľ�ɫ��Ȩ��
        SimpleAuthorizationInfo sainfo = new  SimpleAuthorizationInfo();
        Set<String> roles = new  HashSet<String>();
        roles.add("admin");
        //roles.add("role1");
        Set<String> permissions = new  HashSet<String>();
        permissions.add("add");
        permissions.add("delete");
        sainfo.setRoles(roles);
         sainfo.setStringPermissions(permissions);
        return sainfo;
    }
    
    // �������������½����
    @Override
    protected AuthenticationInfo  doGetAuthenticationInfo(AuthenticationToken  arg0)
        throws AuthenticationException
    {
    UsernamePasswordToken token =  (UsernamePasswordToken) arg0;
        //String username = token.getUsername();
        // ����username�����ݿ�����û����õ�����
        // �����ҵ����û�����
    //User user =  service.login(new User(token.getUsername(),new String(token.getPassword())));
    C_operator user =  service.login(new C_operator(token.getUsername(),new String(token.getPassword())));
        
    Subject currentUser = SecurityUtils.getSubject();
    Session session = currentUser.getSession();
    session.touch();
    session.setAttribute("C_operator",user);
    
    if (null == user)
        {
            throw new  AccountException("username is not exist");
        }
        //SecurityUtils.getSubject().getSession().setTimeout(5000);
        return new  SimpleAuthenticationInfo(arg0,token.getPassword(),token.getUsername());
    }
}