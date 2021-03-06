/*******************************************************************************
 * Copyright (c) 2006, 2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.services.repositoryservice.junit;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import org.ebayopensource.turmeric.assetcreation.AssetCreatorFactory;
import org.ebayopensource.turmeric.assetcreation.AssetCreatorIntf;
import org.ebayopensource.turmeric.assetcreation.exception.AssetCreationException;
import org.ebayopensource.turmeric.repository.v2.services.*;
import org.ebayopensource.turmeric.services.repositoryservice.operation.consumer.RejectAssetConsumer;

public class RejectAssetTest {

   public static AssetCreatorIntf assetCreator = AssetCreatorFactory
            .getAssetCreator("resource/FunctionalDomainAsset.xml");

   @BeforeClass
   public static void oneTimeSetUp() throws AssetCreationException {
      try {
         assetCreator.createAsset();
         // Connection connection = ConnectionUtil.getInstance().getDefaultConnection();
         // assetSource = AssetSourceFactory.createAssetSource(connection);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   private static final String s_success = "PASSED";

   /*
    * Method under test: RejectAsset Test Type : Positive Sub Type : validAsset with Name
    */
   @Test
   public void testGetAssetStatus_validAsset_WithName() throws Exception {

      AssetInfo assetInfo = assetCreator.getAssetAsAssetInfo("Common");
      AssetKey assetKey = assetInfo.getBasicAssetInfo().getAssetKey();
      assetInfo.getBasicAssetInfo().getAssetKey().getAssetId();
      // Asset asset = assetSource.getAsset(assetId, false);
      // AssetInfoForUpdate updateInfo = assetCreator.getAssetInfoForUpdate(assetInfo);
      // updateInfo.getBasicAssetInfo().setAssetDescription("Modified");
      AssetInfoForUpdate updateInfo = assetCreator.getAssetInfoForUpdate(assetInfo);
      ExtendedAssetInfo extendedAssetInfo = new ExtendedAssetInfo();
      AttributeNameValue lifeCycleState = new AttributeNameValue();
      lifeCycleState.setAttributeName("lifecycle_state");
      lifeCycleState.setAttributeValueString("Deployed");
      extendedAssetInfo.getAttribute().add(lifeCycleState);
      updateInfo.setExtendedAssetInfo(extendedAssetInfo);
      assetCreator.updateCompleteAsset(updateInfo);
      // ExtListenerHandlerUtil.setEvent(asset, event, user);
      String status = RejectAssetConsumer.testGetAssetStatus_validAsset_WithName(assetInfo);
      assetCreator.removeAsset(assetKey);
      assertEquals(s_success, status);
   }

   /*
    * Method under test: RejectAsset Test Type : Positive Sub Type : validAsset with ID
    */
   @Test
   public void testGetAssetStatus_validAsset_WithId() throws Exception {
      AssetInfo assetInfo = assetCreator.getAssetAsAssetInfo("Common");
      AssetKey assetKey = new AssetKey();
      assetKey.setAssetId(assetInfo.getBasicAssetInfo().getAssetKey().getAssetId());
      assetKey.setAssetName(assetInfo.getBasicAssetInfo().getAssetKey().getAssetName());
      assetInfo.getBasicAssetInfo().getAssetKey().getAssetId();

      AssetInfoForUpdate updateInfo = assetCreator.getAssetInfoForUpdate(assetInfo);
      updateInfo.getBasicAssetInfo().setAssetDescription("Modified");
      assetCreator.updateCompleteAsset(updateInfo);
      // ExtListenerHandlerUtil.setEvent(asset, event, user);

      String status = RejectAssetConsumer.testGetAssetStatus_validAsset_WithId(assetInfo);

      assetCreator.removeAsset(assetKey);
      assertEquals(s_success, status);
   }

   /*
    * Method under test: RejectAsset Test Type : Negative Sub Type : invalid role
    */
   @Test
   public void testGetAssetStatus_invalidRole() throws Exception {

      AssetInfo assetInfo = assetCreator.getAssetAsAssetInfo("Common");
      AssetKey assetKey = new AssetKey();
      assetKey.setAssetId(assetInfo.getBasicAssetInfo().getAssetKey().getAssetId());
      assetKey.setAssetName(assetInfo.getBasicAssetInfo().getAssetKey().getAssetName());
      assetInfo.getBasicAssetInfo().getAssetKey().getAssetId();

      AssetInfoForUpdate updateInfo = assetCreator.getAssetInfoForUpdate(assetInfo);
      updateInfo.getBasicAssetInfo().setAssetDescription("Modified");
      assetCreator.updateCompleteAsset(updateInfo);
      // ExtListenerHandlerUtil.setEvent(asset, event, user);

      String status = RejectAssetConsumer.testGetAssetStatus_invalidRole(assetInfo);

      assetCreator.removeAsset(assetKey);
      assertEquals(s_success, status);
   }
}
