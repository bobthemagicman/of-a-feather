/**
 *
 *   Copyright 2015 Justen L. Britain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 **/
package com.ofafeather.domain.service.impl;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * AutoConnectionSignUp.java
 *
 * @author Justen L. Britain
 * @date May 26, 2014
 *
 */
public class AutoConnectionSignUp implements ConnectionSignUp
{

    //private final UserService userDetailsService;
    
//    public AutoConnectionSignUp(UserService userDetailsService)
//    {
//        this.userDetailsService = userDetailsService;
//    }

    @Override
    public String execute(Connection<?> connection)
    {
//        UserProfile profile = connection.fetchUserProfile();
//        
//        ConnectionKey key = connection.getKey();
//        SocialMediaProvider provider = SocialMediaProvider.valueOf(key.getProviderId().toUpperCase());
//        TreeSet<SocialMediaProvider> socialSigninProviders = Sets.newTreeSet(Arrays.asList(provider));
//        
//        ApplicationUserImpl applicaitonUser = new ApplicationUserImpl("", profile.getEmail(), "", Collections.<GrantedAuthority>emptySet(),
//                profile.getEmail(), profile.getFirstName(), profile.getLastName(), socialSigninProviders, UserRole.ROLE_USER, null, null, profile.getUsername());
//        
//        try
//        {
//            return userDetailsService.registerNewUserAccount(applicaitonUser).getUserId();
//        } catch (DuplicateEmailException e)
//        {
//            // TODO jbritain log exception here as warning            
//        }
//        
        return null;       
    }
}
