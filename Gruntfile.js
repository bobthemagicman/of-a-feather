module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    bower: { 
      options: {
        targetDir: 'target/ofAFeather/resources/'
      },
      prod: {},
      dev: {},
      test: {}
    },
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
      },
      prod: {},
      dev: {},
      test: {}
    },
    qunit: {
      prod: {},
      dev: {},
      test: {}
    },
    concat: {
      prod: {},
      dev: {},
      test: {}
    },
    less: {
      prod: {},
      dev: {},
      test: {}
    }
  });

  grunt.loadNpmTasks('grunt-bower-task');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-qunit');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-less'); 
  
  grunt.registerTask('default', ['bower']);
};
