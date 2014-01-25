#---------------------------------------------
# Makefile that automatically do the job when files are modified
# need the following command:
#
# guard start
#
#---------------------------------------------
require 'asciidoctor'
require 'erb'

guard 'shell' do
  watch(/.*\.txt$/) {|m|
    Asciidoctor.render_file(m[0], :in_place => true, :attributes => {
'stylesheet' => 'stylesheets/golo-jmb.css',
'icons' => true, 'iconsdir' => '/Users/bruel/dev/images/icons',
'data-uri' => true,
'numbered' => true,
'safe-mode' => 'Safe'
})
  }
end

#---------------------------------------------
# refresh Chrome browser
#---------------------------------------------
guard 'livereload' do
  watch(%r{^.+\.(css|js|html)$})
end