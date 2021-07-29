[![Build](https://github.com/applibgroup/MaterialCalendar/actions/workflows/main.yml/badge.svg)](https://github.com/applibgroup/MaterialCalendar/actions/workflows/main.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=applibgroup_MaterialCalendar&metric=alert_status)](https://sonarcloud.io/dashboard?id=applibgroup_MaterialCalendar)

# Material Design Calendar
A Material design calendar inspired by the CalendarView of School Diary.
<p>
	<image src = "/Material%20Calendar.png" width = 320 height = 512)/>
</p>

# Source
This library has been inspired by [jMavarez\\MaterialCalendar](https://github.com/jMavarez/MaterialCalendar).

## Integration

1. For using MaterialCalendar module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```
 implementation project(path: ':materialcalendar')
```
2. For using MaterialCalendar module in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```
 implementation fileTree(dir: 'libs', include: ['*.har'])
```
3. For using MaterialCalendar module from a remote repository in separate application, add the below dependencies in entry/build.gradle file.
```
implementation 'dev.applibgroup:materialcalendar:1.0.1'
```

## Usage
 1. Add CalendarView into your layouts or view hierarchy.

Example:

```xml
    <com.jmavarez.materialcalendar.CalendarView
                ohos:height="match_content"
                ohos:width="match_parent"
                ohos:id="$+id:calendarView"
		app:mc_color="$color:colorPrimary"
	/>
```
Check the example app for more information.

## License

	Copyright (c) Josue Mavarez 2017

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

