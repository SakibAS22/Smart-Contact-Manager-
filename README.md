<!-- ! This is to make Tailwndcss dynamic -->
npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch

spring.thymeleaf.cache=false :::	Forces Thymeleaf to reload .html files on every request ✅
spring.devtools.restart.enabled=true :::	Enables automatic restart when code or config changes ✅
spring.devtools.livereload.enabled=true :::	Allows automatic browser refresh (if using LiveReload extension) 🔄

<!-- ? We are using theamLeaf which support Server side Rendering(SSR) so when to to new page it will always reload the page -->

<!-- ! Fragment -->
1. Create a fragment using synatx[ th:fragemnt="name of fragment" ]{It is a parent which is going to be used by others}
2. use synatx[ th:insert="~{parent filename :: name of fragment} ]
<!-- ? By this way we not need to write every where we can writw onece and use it using inser fragment and by using fragment the host tag will not be replace -->
<!-- name of the fragment can take parameter eg(a,b) -->
    <h1>Value of x is <span th:text="${a}"></span></h1>
    This need to write to print the value 

<!-- ! In thymleaf for content we can either use replace or insert both work same -->


<!-- ? Second method is by replacing the host-tag -->

<!-- ! I have used Lambok in project so need to write seperate getter and setter method -->
<!-- We are used one to many Mapping -->

<!-- ? For alignment of register card we have use grid insted of flex -->
<!-- ? th:field="*{name}" is used to access inner data -->
<!-- ? Cntrl + .  to add all implementation to abstract method (It will create all abstract method to give implementation) -->

<!-- ! Used Spring  boot starter dependency for vaidation -->

<!-- ? THis is used to pass data {loggedInUser} -->


<!-- ! We are using Cloudinary  -->
<!-- ? Why we use cloudinary insted of Amazon S3 is because amazon is capable of handling  all but coludinary is focused on images and video and we are curently working on images so we go with cloudinary -->

<!-- !Cloudinary  me mail {sakibsankeshwarkar000@gmail.com} hai -->
<!-- Cloudinary is a media management platform focused on images and videos, offering advanced tools for storage, optimization, manipulation, and delivery. It’s tailored for projects requiring dynamic media processing and fast delivery. -->

<!-- ! For custom validation of image fie size we made annotation in pakage validaters -->

<!-- ! for search contacts we make IgnoreCase while searching -->

<!-- ! {Sweetheart} used for pop up of delete icon of contact -->