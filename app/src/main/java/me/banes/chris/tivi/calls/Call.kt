/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.banes.chris.tivi.calls

import android.arch.paging.LivePagedListProvider
import io.reactivex.Completable
import io.reactivex.Flowable

interface Call<in Param, DatabaseOutput> {
    fun data(): Flowable<DatabaseOutput>
    fun refresh(param: Param): Completable
}

interface ListCall<in Param, DatabaseOutput> : Call<Param, List<DatabaseOutput>> {
    fun liveList(): LivePagedListProvider<Int, DatabaseOutput>
    val pageSize: Int
}