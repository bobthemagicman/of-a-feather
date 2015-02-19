<div class="log-in-modal modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Log in</h4>
            </div>
            <div id="log-in-modal-body" class="modal-body">
                <div class="social-container">
                    <a href="<c:url value="/auth/facebook"/>"><button class="btn btn-xlarge btn-facebook"><i class="fa fa-facebook"></i> | Connect with Facebook</button></a>
                    <a href="<c:url value="/auth/twitter"/>"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Connect with Twitter</button></a>
                </div>

                <div class="or-separator">
                    <h6 class="separator-text">or</h6>
                    <hr>
                </div>

                <form accept-charset="UTF-8" action="${pageContext.request.contextPath}/signin/authenticate" class="signin-form login-form" data-action="Signin" method="post" role="form">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="form-group">
                        <input class="form-control" id="user-email" name="username" placeholder="Email Address" type="email">
                    </div>
                    
                    <div class="form-group">
                        <input class="form-control" id="signin_password" name="password" placeholder="Password" type="password">
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <div class="checkbox remember-me">
                            <label>
                                <input type="checkbox" name="remember_me" id="remember_me" value="true"> Remember me
                            </label>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12">
                        <a href="/forgot_password" class="forgot-password">Forgot password?</a>
                    </div>
                    
                    <button type="submit" class="btn btn-primary btn-block">Log In</button>
                </form>
            </div>
            <div class="modal-footer">
                Don&apos;t have an account? <a href="#" class="switch-to-sign-up-modal">Sign up</a>
            </div>
        </div>
    </div>
</div>
<!-- div class="log-in-modal modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Log in</h4>
            </div>
            <div id="log-in-modal-body" class="modal-body">
                <fb:login-button show-faces="true" width="200" max-rows="1"></fb:login-button>

                <div class="signup-or-separator">
                    <h6 class="text shift text-special">or</h6>
                    <hr>
                </div>

                <form accept-charset="UTF-8" action="/signup" class="signin-form login-form" data-action="Signin" method="post">
                
                </form>
            </div>
            <div class="modal-footer">
                Don&apos;t have an account? <a href="">Sign up</a>
            </div>
        </div>
    </div>
</div -->