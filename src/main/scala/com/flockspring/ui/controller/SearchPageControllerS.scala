/*
 * Copyright 2013 FlockSpring Inc. All rights reserved
 */
package com.flockspring.ui.controller

import scala.collection.JavaConverters.mutableSetAsJavaSetConverter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

import com.flockspring.domain.types.MusicStyle
import com.flockspring.ui.model.AddressUIModel
import com.flockspring.ui.model.ImageUIModel
import com.flockspring.ui.model.LanguageUIModel
import com.flockspring.ui.model.LeaderUIModel
import com.flockspring.ui.model.OrganizationUIModel

/**
 * SearchPageControllerS.scala
 *
 * @author Justen L. Britain
 * @date Sep 8, 2013
 *
 */
//@Controller
class SearchPageControllerS {

//  val log: Logger = LoggerFactory.getLogger(this.getClass.getName)
//
//  @RequestMapping(Array("/search"))
//  def search (query:String, stubMode:String): ModelAndView = {
//    log.debug("HomeController::home")
//
//    var results = scala.collection.Seq[OrganizationUIModel]();
//    
//    if(StringUtils.hasText(query))
//    {
//        val address = new AddressUIModel("123456 56Ave SE", "", "Seattle", "WA", "98001", "USA", 46.25544, 41.2355);
//        val srLdrBiography = "";
//        val description = "";
//        val leaderShipTeam: scala.collection.mutable.Set[LeaderUIModel] = ???;
//        val languages: scala.collection.mutable.Set[LanguageUIModel] = ???;
//        val images: scala.collection.mutable.Set[ImageUIModel] = ???;
//
//        val org1 = new OrganizationUIModel(address, MusicStyle.MODERN, 1999, 
//            "", languages.asJava, "S: 7:00PM S:8:30AM, 11:00AM" , images.asJava, "", 
//            "Non-Denominational", "", "Seattle Way Big Church", "<ul><li>Program 1</li><li>Program 2</li><li>Program 3</li></ul>",
//            "Mostly Younger", "Primarily Caucasian", srLdrBiography, description, "http://wwww.seattlewaybigchurch.conn",
//            "http://wwww.bookofmanyfaces.conn/Seattle_Way_Big_Church", 
//            2000, true, true, true, leaderShipTeam.asJava, 15);
//        
//        
//        results.+:(Seq[OrganizationUIModel](org1));
//    }
//    
//    new ModelAndView("searchResultsPage", "results", results);
//  }
}