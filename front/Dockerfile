FROM node:16.20.2-bullseye-slim AS build

WORKDIR /usr/local/app

COPY package.json package-lock.json ./
RUN npm ci

COPY ./ ./
RUN npm run build

FROM nginx:1.27-alpine AS production

COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/local/app/dist/bobapp /usr/share/nginx/html

EXPOSE 80
