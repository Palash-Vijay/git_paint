

module.exports = function(grunt) {


    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON("package.json"),

        clean: {
            pre_build: [

            ],
            post_build: [
            ]        
        },

        concat: {
            concat_tags: {
                src:  "./tags/**/*.html",
                dest: "./bin/tags/concat_tags.tag",
            },
            
            concat_scss: {
                src: "./tags/**/*.scss",
                dest: "./bin/tags/concat_css.scss",
            }
        },

        sass: {
            transpile_scss: {
                options: {
                    compass: true,
                    trace: true
                },
                files: [{
                    expand: true,
                    src: "./bin/tags/concat_css.scss",
                    ext: '.css',
                    dest: "./"
                }]
            }
        },


        riot: {
            options: {
                compact: true
            },
            tags: {
                src: "./bin/tags/concat_tags.tag",
                dest: "./bin/tags/tags.js"
            }
        },

    });

    // Load the plugin that provides the "clean" task.
    grunt.loadNpmTasks('grunt-contrib-clean');

    // Load the plugin that provides the "riot" task.
    grunt.loadNpmTasks("grunt-riot");

    // Load the plugin that provides the "concat" task.
    grunt.loadNpmTasks("grunt-contrib-concat");

    // Load the plugin that provides the "sass" task.
    grunt.loadNpmTasks('grunt-sass');

    // Load the plugin that provides the "cssmin" task.
    grunt.loadNpmTasks('grunt-contrib-cssmin');

    // Load the plugin that provides the "htmlmin" task.
    grunt.loadNpmTasks('grunt-contrib-htmlmin');

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-uglify');

    // Load the plugin that provides the "asset-version" task.
    grunt.loadNpmTasks('grunt-asset-version-json');

    // Load the grunt app chache so that app cache is updated automatically
    grunt.loadNpmTasks('grunt-appcache');

    // Load the grunt riot so that transformation of tags is done on server itself
    grunt.loadNpmTasks('grunt-riot');

    //Task for building css static contents of the application
    grunt.registerTask("make-css", ["concat:concat_scss","sass"]);

    //Task for building javascript static contents of the application
    grunt.registerTask("make-js", ["concat:concat_tags",  "riot"]);

    //Task for building the static contents of the application
    grunt.registerTask("default", ["clean:pre_build", "make-css", "make-js" ]);

};