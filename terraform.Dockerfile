FROM alpine

RUN wget -O /tmp/terraform.zip https://releases.hashicorp.com/terraform/1.0.1/terraform_1.0.1_linux_amd64.zip
RUN unzip /tmp/terraform.zip -d /

USER nobody
