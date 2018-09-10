module.exports = function(grunt) {
    var ignoreMain = [
        '!**/node_modules/**',
        '!**/.idea/**',
        '!**/*.text**',
        '!**/*.txt**',
        '!**/.DS_Store**',
        '!.DS_Store',
        '!dist',
        '!**/__MACOSX/**',
        '!__MACOSX',
        '!**/__macosx/**',
        '!validation-report.json',
        '!validation-status.json',
        '!npm-debug.log'
    ]

    var ignoreSite = [
        '!**/less/**',
        '!**/js/inc/**',
        '!**/js/app.js**',
        '!**/package.json**',
        '!**/gruntfile.js**',
        '!**/css/inc/**',
        '!vendors/bower.json'
    ]


    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        //Concat JS
        concat: {
            dist: {
                src: ['js/inc/actions.js', 'js/inc/functions.js'],
                dest: 'js/app.js',
            },
        },

        //Minify JS
        uglify: {
            options: {
                mangle: false
            },
            my_target: {
                files: {
                    'js/app.min.js': ['js/app.js'],
                    'js/page-loader.min.js': ['js/page-loader.js']
                }
            }
        },

        //Compile LESS to CSS
        less: {
            development: {
                options: {
                    paths: ["css"]
                },
                files: {
                    "css/app.css": "less/app.less",
                },
                cleancss: true
            },

        },

        //Split CSS file to gain IE9 support
        csssplit: {
            your_target: {
                src: ['css/app.css'],
                dest: 'css/app.css',
                options: {
                    maxSelectors: 4000,
                    suffix: '_'
                }
            },
        },

        //Minify CSS
        cssmin: {
            options: {
                keepSpecialComments: 0
            },
            target: {
                files: {
                    'css/app_1.min.css': ['css/app_1.css'],
                    'css/app_2.min.css': ['css/app_2.css'],
                }
            }
        },

        //Create distributed version
        copy: {
            site: {
                expand: true,
                cwd: '',
                src: ['**/*', ignoreMain, ignoreSite],
                dest: 'dist/'
            },
            wb: {
                expand: true,
                cwd: '',
                src: ['**/*', ignoreMain],
                dest: 'dist-wb/'
            }
        },

        //Clean temp and other unwanted files and folders
        clean: ['**/.idea', '**/.DS_Store', 'dist', '__MACOSX', '__macosx', 'npm-debug.log'],

        //This task is used to replace images sources with placehold images. Please ignore this.
        cdnify: {
            someTarget: {
                options: {
                    rewriter: function (url) {
                        if(url.indexOf('img/demo/banks') === 0) {
                            return 'https://placeholdit.imgix.net/~text?&w=120&h=108'
                        } else if (url.indexOf('img/demo/blog') === 0) {
                            return 'https://placeholdit.imgix.net/~text?&w=960&h=520'
                        } else if ((url.indexOf('img/demo/listing/thumbs') === 0) || url.indexOf('../img/demo/listing/thumbs') === 0) {
                            return 'https://placeholdit.imgix.net/~text?&w=400&h=266'
                        } else if ((url.indexOf('img/demo/listing') === 0) || (url.indexOf('../img/demo/listing') === 0)) {
                            return 'https://placeholdit.imgix.net/~text?&w=960&h=600'
                        } else if ((url.indexOf('img/demo/people') === 0) || (url.indexOf('img/demo/locations') === 0) || (url.indexOf('../img/demo/people') === 0) || (url.indexOf('../img/demo/locations') === 0)) {
                            return 'https://placeholdit.imgix.net/~text?&w=500&h=500'
                        } else if (url.indexOf('img/demo/floor-plan.png') === 0) {
                            return 'https://placeholdit.imgix.net/~text?&w=1000&h=464'
                        } else {
                            return url
                        }
                    },
                    html: {
                        'link[rel="shortcut icon"]': false,
                        'link[rel=icon]': false,
                        'link[rel="stylesheet"]': false,
                        'script[src]': false,
                        'source[src]': false,
                        'video[poster]': false
                    }
                },
                files: [{
                    expand: true,
                    cwd: '',
                    src: ['dist-wb/**.html', 'dist-wb/dashboard/**.html', 'dist-wb/email/**.html'],
                }]
            }
        },

        //Watch LESS and JS file changes and execute tasks
        watch: {
            less: {
                files: ['less/**/*.less'],
                tasks: ['less', 'csssplit', 'cssmin']
            },
            js: {
                files: ['js/inc/**/*.js'],
                tasks: ['concat', 'uglify']
            },
            jsPageLoader: {
                files: ['js/page-loader.js'],
                tasks: ['concat', 'uglify']
            }

        }
    });

    // Load the plugin that provides the "less" task.
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-csssplit');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-cdnify');

    grunt.registerTask('dist', ['clean', 'copy:site']);
    grunt.registerTask('dist-wb', ['clean', 'copy:wb', 'cdnify']);
};
