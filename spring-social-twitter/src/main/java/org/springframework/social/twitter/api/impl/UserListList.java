/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.twitter.api.impl;

import java.util.List;

import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.UserList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Holder for list of UserList, pulled from JSON object's "lists" property.
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class UserListList {
	private final CursoredList<UserList> list;

	@JsonCreator
	public UserListList(
			@JsonProperty("lists") List<UserList> list,
			@JsonProperty("previous_cursor") long previousCursor,
			@JsonProperty("next_cursor") long nextCursor) {
		this.list = new CursoredList<UserList>(list, previousCursor, nextCursor);
	}

	@JsonIgnore
	public CursoredList<UserList> getList() {
		return list;
	}
}
