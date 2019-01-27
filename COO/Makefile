#-----------------------------------------------------
MAIN=cours
ICONSDIR=.
IMAGESDIR=./images
#STYLE=/Users/bruel/Dropbox/Public/dev/asciidoc/stylesheets/golo-jmb.css
#STYLE=/Users/bruel/dev/asciidoctor/asciidoctor-stylesheet-factory/stylesheets/jmb.css
#ASCIIDOC=asciidoc -a icons -a iconsdir=$(ICONSDIR) -a stylesheet=$(STYLE) -a imagesdir=$(IMAGESDIR) -a data-uri
#HIGHLIGHT=coderay
#HIGHLIGHT=highlightjs
#HIGHLIGHT=prettify
HIGHLIGHT=pygments
DOCTOR=asciidoctor -a icons=font -a imagesdir=$(IMAGESDIR) -a source-highlighter=$(HIGHLIGHT) -a data-uri
#BACKENDS=asciidoctor-deck.js
#DECKJS=$(BACKENDS)/templates/haml/
BACKENDS=../../asciidoctor-backends
DECKJS=$(BACKENDS)/haml/
#DECK=web-2.0
DECK=swiss
#DECK=neon
#DECK=beamer
EXT=adoc
PANDOC=pandoc
OUTPUT=.
DEP=
SOURCEFILES = ./src/java/CodingDojo/src/*.java
DOC = doc
DZSLIDES=../../asciidoctor-backends/slim/dzslides
STYLE=../../slides/jmb.css
ASCIIDOCTOR=asciidoctor -a icons=font -a iconsdir=$(ICONSDIR)  -a imagesdir=$(IMAGESDIR)
SITE=../jmbruel.github.io/teaching
#THEME=colony
THEME=riak
#-----------------------------------------------------

all: $(OUTPUT)/*.html

images/%.png: images/%.plantuml
	@echo '==> Compiling plantUML files to generate PNG'
	java -jar plantuml.jar $<

images/%.svg: images/%.plantuml
	@echo '==> Compiling plantUML files to generate SVG'
	java -jar plantuml.jar -t SVG $<

pattern/%.png: pattern/%.plantuml
	@echo '==> Compiling plantUML files to generate PNG'
	java -jar plantuml.jar $<

%.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a toc2 -b html5 -a numbered -a eleve -a linkcss! -r asciidoctor-diagram $<

%.full.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a toc2 -a data-uri -b html5 -a numbered -a eleve -o $@ $<

%.deckjs.html: %.$(EXT)  $(DEP)
	@echo '==> Compiling asciidoc files to generate Deckjs'
	$(DOCTOR) -T ../../asciidoctor-deck.js/templates/haml/ -a slides \
	-a deckjs_theme=$(DECK) \
	-r asciidoctor-diagram \
	-a icons=font \
	-a prof -o $@ $<

%.reveal.html: %.$(EXT)  $(DEP)
	@echo '==> Compiling asciidoc files to generate reveal.js'
	$(DOCTOR) -T ../asciidoctor-backends/haml/reveal/ \
	-a slides -a data-uri -a deckjs_theme=$(DECK) -a icons=font \
	-a stylesheet=$(STYLE) -a images=$(IMAGESDIR) -o $@ $<

$(OUTPUT)/%.slides.html: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate Deckjs'
	$(ASCIIDOCTOR) -b dzslides \
	-T $(DZSLIDES) -E slim \
	-a slides \
	-r asciidoctor-diagram \
	-a data-uri \
	-o $@ $<

%.xml: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate DocBook'
	$(DOCTOR) -b docbook -a docbook $< -o $@

%.wiki: %.xml
	@echo '==> Compiling DocBook files with Pandoc to generate MediaWiki'
	$(PANDOC) -f docbook -t mediawiki -s $< -o $@

roadmap.html: $(MAIN).$(EXT)
	@echo '==> Compiling asciidoc files to generate standalone file for Google Drive'
	$(DOCTOR) -b html5 -a numbered -a data-uri $< -o $@

%-sujet.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a compact -a theme=compact -b html5 -a numbered -a eleve \
	-a data-uri $< -o $@
	$(DOCTOR) -b html5 -a numbered -a eleve -a linkcss! -r asciidoctor-diagram $<

%-prof.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a prof -a correction -a theme=compact -b html5 -r asciidoctor-diagram \
	-a data-uri $< -o $@

%.pdf: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	asciidoctor-pdf  -a icons=font -a imagesdir=$(IMAGESDIR) -a source-highlighter=$(HIGHLIGHT) -a theme=compact -r asciidoctor-diagram $< -o $@

deploy:
	cp main.html index.html
	git commit -am "maj du cours au fur et à mesure"
	git co gh-pages
	git co master index.html
	git push

cours:
	$(DOCTOR) -a toc2 -b html5 -a numbered -a stylesheet=$(STYLE) -o cours.html cours.asc

test:
	$(DOCTOR) -a toc2 -b html5 -a numbered -a stylesheet=$(STYLE) -o wip2.html wip.asc
	$(DOCTOR) -T /Users/bruel/dev/asciidoctor-backends/haml/deckjs/ -a slides \
	-a data-uri -a deckjs_theme=$(DECK) -a icons -a iconsdir=$(ICONSDIR) \
	-a images=$(IMAGESDIR) -a prof -a stylesheet=$(STYLE) -o wip2.deckjs.html wip.asc

javadoc : $(CLASSFILES)
	javadoc -version -author -doclet org.asciidoctor.Asciidoclet -docletpath doclet/asciidoclet-1.5.0.jar -overview -d $(DOC) $(SOURCEFILES)
