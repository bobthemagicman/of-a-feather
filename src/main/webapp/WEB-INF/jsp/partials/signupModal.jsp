<div class="sign-up-modal modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Sign up</h4>
            </div>
            <div id="sign-up-modal-body" class="modal-body">
                <fb:login-button show-faces="true" width="200" max-rows="1"></fb:login-button>

                <div class="or-separator">
                    <h6 class="separator-text">or</h6>
                    <hr>
                </div>
                <a href="#" class="email-sign-up">Sign up with Email</a>
                <form accept-charset="UTF-8" action="/authenticate" class="sign-up-form" data-action="Signup" method="post" role="form" style="display: none">
                    <div class="form-group">
                        <input class="form-control" id="signup_firstname" name="firstname" placeholder="First Name" type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="signup_lastname" name="lastname" placeholder="Last Name" type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="signup_email" name="email" placeholder="Email Address" type="email">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="signup_password" name="password" placeholder="Password" type="password">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="signup_password_confirm" name="password_confirm" placeholder="Confirm Password" type="password">
                    </div>
                    
                    <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
                </form>
                <p class="agree-terms">By signing up, I agree to Of A Feather&apos;s <a href="#">Privacy Policy</a> and <a href="#">Terms &amp; Conditions</a>.</p>
                    
            </div>
            <div class="modal-footer">
                Already a member? <a href="#" class="switch-to-log-in-modal">Log in</a>
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

                <form accept-charset="UTF-8" action="/authenticate" class="signin-form login-form" data-action="Signin" method="post">
                    <div class="control-group row-space-1">
                        <input class="decorative-input" id="signin_email" name="email" placeholder="Email Address" type="email">
                    </div>
                    
                    <div class="control-group row-space-2">
                        <input class="decorative-input" id="signin_password" name="password" placeholder="Password" type="password">
                    </div>

                    <div class="clearfix row-space-2">
                       <label for="remember_me2" class="checkbox remember-me">
                          <input type="checkbox" name="remember_me" id="remember_me2" value="true" class="remember_me"> Remember me
                       </label>
                       <a href="/forgot_password" class="forgot-password">Forgot password?</a>
                    </div>

                    <button type="submit" class="btn btn-block btn-primary large btn-large padded-btn-block">Log In</button>
                </form>
            </div>
            <div class="modal-footer">
                Don&apos;t have an account? <a href="">Sign up</a>
            </div>
        </div>
    </div>
</div -->