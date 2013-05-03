// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.avatars.externalurl;

import com.google.gerrit.extensions.annotations.Listen;
import com.google.gerrit.reviewdb.client.AccountExternalId;
import com.google.gerrit.reviewdb.client.AccountExternalId.Key;
import com.google.gerrit.server.IdentifiedUser;
import com.google.gerrit.server.avatar.AvatarProvider;
import com.google.gerrit.server.config.CanonicalWebUrl;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Nullable;

@Listen
@Singleton
public class ExternalUrlAvatarProvider implements AvatarProvider {

  private final boolean ssl;

  @Inject
  ExternalUrlAvatarProvider(@CanonicalWebUrl @Nullable String canonicalUrl) {
    ssl = canonicalUrl != null && canonicalUrl.startsWith("https://");
  }

  @Override
  public String getUrl(IdentifiedUser forUser, int imageSize) {
    // AccountExternalId data = new AccountExternalId(forUser.getAccountId(), new AccountExternalId.Key("avatar"));

    Logger log = LoggerFactory.getLogger(ExternalUrlAvatarProvider.class);
    log.warn("getUrl called");

    return "https://gerrit-review.googlesource.com/static/logo.png";
  }

  @Override
  public String getChangeAvatarUrl(IdentifiedUser forUser) {
    // TODO Auto-generated method stub
    return "http://example.org";
  }
}
