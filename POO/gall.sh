
asciidoc   -a toc   -a data-uri   -a icons   -a eleve   -o $1_Sujet.html   $1.asc
# asciidoc   -a toc   -a data-uri   -a icons   -a eleve   -a stylesheet=stylesheets/golo-jmb.css  -a impression   -o $1_SujetPrintable.html   $1.asc
asciidoc   -a toc   -a data-uri   -a icons   -a prof   -o $1_Support.html   $1.asc
asciidoc   -a toc   -a data-uri   -a icons   -a prof   -a todoprof  -o $1_Profs.html   $1.asc
asciidoc --backend slidy2 -a data-uri -a icons -a toc -a prof  -o $1_SupportSlides.html   $1.asc


